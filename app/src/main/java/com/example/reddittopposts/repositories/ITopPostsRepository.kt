package com.example.reddittopposts.repositories

import androidx.paging.PagingData
import com.example.reddittopposts.entities.PostModel
import com.example.reddittopposts.entities.parseModels.Children
import kotlinx.coroutines.flow.Flow

interface ITopPostsRepository {
    fun getPagedPosts(): Flow<PagingData<Children>>

}
