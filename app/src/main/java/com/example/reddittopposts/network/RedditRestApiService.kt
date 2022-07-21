package com.example.reddittopposts.network

import com.example.reddittopposts.entities.parseModels.RedditData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RedditRestApiService {

    @Headers("Content-Type: application/json")
    @GET("top.json?")
    suspend fun getRedditTop(
        @Query("after") next_page_key: String,
    ): Response<RedditData>
}