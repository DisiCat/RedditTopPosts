package com.example.reddittopposts.usecases

import androidx.paging.PagingData
import com.example.reddittopposts.entities.PostModel
import kotlinx.coroutines.flow.Flow


interface ITopPostsUseCase {
 fun   getRedditData() : Flow<PagingData<PostModel>>
}