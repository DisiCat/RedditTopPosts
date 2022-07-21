package com.example.reddittopposts.adapters

import android.content.res.Resources
import android.provider.Settings.Global.getString
import android.provider.Settings.System.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.reddittopposts.R
import com.example.reddittopposts.databinding.PostItemRvBinding
import com.example.reddittopposts.entities.PostModel
import com.squareup.picasso.Picasso

class TopPostsActivityAdapter(
    private val thumbnailClickListener: (String?) -> Unit,
    private val downloadButtonClickListener: (PostModel) -> Unit
) :
    PagingDataAdapter<PostModel, TopPostsActivityAdapter.ViewHolder>(DataDiffItemCallback) {

    class ViewHolder(val binding: PostItemRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            postModel: PostModel,
            thumbnailClickListener: (String?) -> Unit,
            downloadButtonClickListener: (PostModel) -> Unit
        ) {
            if (!postModel.thumbnailUrl.isNullOrEmpty()) {
                binding.contentPreviewImage.visibility = View.VISIBLE
                Picasso.get().load(postModel.thumbnailUrl).into(binding.contentPreviewImage)
            } else {
                binding.contentPreviewImage.visibility = View.GONE
            }
            if (postModel.isVideo) {
                binding.downloadImageTextView.setText(R.string.download_video)
            } else {
                binding.downloadImageTextView.setText(R.string.download_image)
            }


            binding.contentPreviewImage.setOnClickListener {
                thumbnailClickListener(postModel.fullFileUrl)
            }
            binding.downloadImageTextView.setOnClickListener {
                downloadButtonClickListener(postModel)
            }
        }
    }

    private object DataDiffItemCallback : DiffUtil.ItemCallback<PostModel>() {
        override fun areItemsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PostModel,
            newItem: PostModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.postModel = getItem(position)
        getItem(position)?.let {
            holder.bind(
                it,
                thumbnailClickListener,
                downloadButtonClickListener
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.post_item_rv,
                parent,
                false
            )
        )
}