package com.example.reddittopposts.entities.parseModels

import com.squareup.moshi.Json

data class ChildData(
    val author: String?,
    @Json(name = "created_utc") val createdUTC: Double?,
    val id: String?,
    @Json(name = "is_video") val isVideo: Boolean?,
    @Json(name = "num_comments") val numComments: Int?,
    val thumbnail: String?,
    val title: String?,
    val url: String?,
    @Json(name = "subreddit_name_prefixed") val subredditNamePrefixed: String?,
    val media: Media?,
)
