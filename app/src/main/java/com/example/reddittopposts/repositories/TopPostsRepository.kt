package com.example.reddittopposts.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.reddittopposts.RedditPagingSource
import com.example.reddittopposts.TopPostsPagingSource
import com.example.reddittopposts.entities.PostModel
import com.example.reddittopposts.entities.parseModels.Children
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TopPostsRepository @Inject constructor(
    private val topPostsPagingSource: TopPostsPagingSource,
    private val redditPagingSource: RedditPagingSource
) : ITopPostsRepository {

    override fun getPagedPosts(): Flow<PagingData<Children>> {

        return Pager(
            config = PagingConfig(
                pageSize = 5,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { redditPagingSource }
        ).flow
    }
}