package com.example.reddittopposts.entities

import com.squareup.moshi.Json

data class RedditPost(
    @Json(name = "kind") var kind: String,
    @Json(name = "data") var data: Data
)
