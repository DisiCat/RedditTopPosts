package com.example.reddittopposts.network

import com.example.reddittopposts.entities.RedditPost
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RedditRestApiService {

    @Headers("Content-Type: application/json")
    @GET("top.json?")
    suspend fun getRedditTop(
       /* @Query("t") t: String,*/
        @Query("count") count : String,
        @Query("limit") limit : String
    ) : Response<RedditPost>

}