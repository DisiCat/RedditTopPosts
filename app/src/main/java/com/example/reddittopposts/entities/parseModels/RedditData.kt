package com.example.reddittopposts.entities.parseModels

import com.squareup.moshi.Json

data class RedditData(
    @Json(name = "kind") var kind: String,
    @Json(name = "data") var data: Data
)
