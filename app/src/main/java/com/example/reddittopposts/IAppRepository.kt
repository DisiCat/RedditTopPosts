package com.example.reddittopposts

interface IAppRepository {
    suspend fun getRedditPosts()
}
