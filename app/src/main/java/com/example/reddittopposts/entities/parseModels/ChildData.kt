package com.example.reddittopposts.entities.parseModels

import com.squareup.moshi.Json

data class ChildData(
    val id: String?,
    val author: String?,
    val thumbnail: String?,
    val title: String?,
    val url: String?,
    val media: Media?,
    @Json(name = "created_utc") val createdUTC: Double?,
    @Json(name = "is_video") val isVideo: Boolean?,
    @Json(name = "num_comments") val numComments: Int?,
    @Json(name = "subreddit_name_prefixed") val subredditNamePrefixed: String?,
)
