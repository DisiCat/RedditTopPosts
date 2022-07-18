package com.example.reddittopposts

import com.example.reddittopposts.network.RedditRestApiService
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val restApiService: RedditRestApiService
) : IAppRepository {

    override suspend fun getRedditPosts(){
       val result = restApiService.getRedditTop( count = "0", limit = "1")

        try {

            if(result.isSuccessful){
              var test = result.body()
                val test1 = test
            }

         } catch (e: Exception){

         }


    }
}