package com.example.reddittopposts.entities.parseModels

import com.squareup.moshi.Json

data class RedditVideo(
    @Json(name = "fallback_url")
    val scrubberMediaURL: String,
)
