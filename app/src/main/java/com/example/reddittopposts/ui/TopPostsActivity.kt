package com.example.reddittopposts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.reddittopposts.R
import com.example.reddittopposts.ui.viewModels.TopPostsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopPostsActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(TopPostsViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getData()
    }
}