package com.example.reddittopposts

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.reddittopposts.entities.PostModel
import com.example.reddittopposts.entities.parseModels.Children
import com.example.reddittopposts.network.RedditRestApiService
import retrofit2.HttpException
import javax.inject.Inject

class TopPostsPagingSource @Inject constructor(
    private val redditRestApiService: RedditRestApiService,
) : PagingSource<Int, Children>() {
    /*override fun getRefreshKey(state: PagingState<Int, PostModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }*/
    override fun getRefreshKey(state: PagingState<Int, Children>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Children> {

        val test = 123123123
        try {

            val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
            val pageSize = params.loadSize.coerceAtMost(MAX_PAGE_SIZE)
            val response = redditRestApiService.getRedditTop(NEXT_PAGE_KEY)

            return if (response.isSuccessful) {
                val posts =
                    response.body()?.data?.children ?: listOf()
                NEXT_PAGE_KEY = response.body()?.data?.after ?: ""
                val nextPageNumber =
                    if (posts.isEmpty() || posts.size < pageSize) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null

                LoadResult.Page(posts, prevPageNumber, nextPageNumber)
            } else {
                LoadResult.Error(HttpException(response))
            }

        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    companion object {

        const val INITIAL_PAGE_NUMBER = 0
        var NEXT_PAGE_KEY = ""
        const val MAX_PAGE_SIZE = 30
    }
}
