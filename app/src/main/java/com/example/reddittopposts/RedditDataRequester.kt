package com.example.reddittopposts

import com.example.reddittopposts.entities.parseModels.RedditData
import com.example.reddittopposts.network.RedditRestApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import javax.inject.Inject

class RedditDataRequester @Inject constructor(
    private val redditRestApiService: RedditRestApiService
) {
    suspend fun sendRequest(nextPadeId: String): Response<RedditData>? {
        return try {
            withContext(Dispatchers.IO) {
                return@withContext redditRestApiService.getRedditTop(nextPadeId)
            }
        } catch (e: Exception) {
            return e.message?.toResponseBody()?.let { Response.error(e.hashCode(), it) }
        }
    }
}