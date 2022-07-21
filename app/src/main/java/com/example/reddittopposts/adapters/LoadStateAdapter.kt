package com.example.reddittopposts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.reddittopposts.R
import com.example.reddittopposts.databinding.LoadStateViewBinding

class LoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<com.example.reddittopposts.adapters.LoadStateAdapter.LoadStateViewHolder>() {


    class LoadStateViewHolder(private val binding: LoadStateViewBinding, retry: () -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.errorLayout.setOnClickListener {
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState) {


            binding.loadingLottieView.isVisible = loadState is LoadState.Loading
            binding.errorLayout.isVisible = loadState is LoadState.Error
        }
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) = LoadStateViewHolder(
        LoadStateViewBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.load_state_view, parent, false)
        ), retry
    )
}