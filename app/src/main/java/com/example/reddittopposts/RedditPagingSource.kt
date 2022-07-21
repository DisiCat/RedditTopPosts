package com.example.reddittopposts

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.reddittopposts.entities.parseModels.Children
import com.example.reddittopposts.network.RedditRestApiService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RedditPagingSource @Inject constructor(
    private val restApiService: RedditRestApiService
) : PagingSource<Int, Children>() {

    override fun getRefreshKey(state: PagingState<Int, Children>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Children> {
        val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
        val pageSize = params.loadSize.coerceAtMost(MAX_PAGE_SIZE)

        return try {
            val responseModel = restApiService.getRedditTop(NEXT_PAGE_KEY)

            if (responseModel.isSuccessful) {
                NEXT_PAGE_KEY = responseModel.body()?.data?.after ?: ""
                val posts =
                    responseModel.body()?.data?.children ?: emptyList()
                val nextPageNumber =
                    if (posts.isEmpty() || posts.size < pageSize) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
                LoadResult.Page(data = posts, prevKey = prevPageNumber, nextKey = nextPageNumber)

            } else {
                return LoadResult.Error(HttpException(responseModel))
            }
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {

        const val INITIAL_PAGE_NUMBER = 0
        var NEXT_PAGE_KEY = ""
        const val MAX_PAGE_SIZE = 30
    }
}

