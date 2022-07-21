package com.example.reddittopposts.ui

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reddittopposts.adapters.TopPostsActivityAdapter
import com.example.reddittopposts.databinding.ActivityMainBinding
import com.example.reddittopposts.entities.PostModel
import com.example.reddittopposts.ui.viewModels.TopPostsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class TopPostsActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(TopPostsViewModel::class.java) }
    private var adapter: TopPostsActivityAdapter? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initViewModel()
        initAdapter()
    }


    private fun initViewModel() {
        lifecycleScope.launchWhenCreated {
            viewModel.getData().collectLatest {
                adapter?.submitData(it)
            }
        }
    }

    private fun initAdapter() {
        adapter = TopPostsActivityAdapter({ string -> clickCardThumbnail(string) },
            { model -> clickFileDownload(model) })
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun clickCardThumbnail(url: String?) {
        if (!url.isNullOrEmpty()) {
            openFileUrl(url)
        }
    }

    private fun openFileUrl(url: String) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(url)
        startActivity(openURL)
    }
    private fun clickFileDownload(postModel: PostModel) {
        val manager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val uri =
            Uri.parse(postModel.fullFileUrl)
        val type = postModel.fullFileUrl?.substringAfterLast('.')

        if ((type?.length ?: return) < 4) {
            val request = DownloadManager.Request(uri)
                .setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_DOWNLOADS,
                    "reddit_image_${postModel.author}.$type"
                )
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
            val reference: Long = manager.enqueue(request)

            val receiver = object : BroadcastReceiver() {
                override fun onReceive(p0: Context?, p1: Intent?) {
                    val id: Long? = p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                    if (id == reference)
                        Toast.makeText(
                            applicationContext, "Downloading File",
                            Toast.LENGTH_LONG
                        ).show()
                }
            }
            registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
        } else {
            Toast.makeText(
                applicationContext, "Not Downloading File",
                Toast.LENGTH_LONG
            ).show()
        }
    }
        override fun onDestroy() {
            super.onDestroy()
            adapter = null
        }
    }