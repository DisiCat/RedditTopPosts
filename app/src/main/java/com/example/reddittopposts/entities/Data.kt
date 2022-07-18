package com.example.reddittopposts.entities

import com.squareup.moshi.Json

data class Data(
    val after: String,
    val dist: Long,
    val modhash: String,
    @Json(name = "geo_filter")
    val geoFilter: String,
    val children: List<Children>,
    val before: Any? = null
)
