package com.example.reddittopposts.entities

data class PostModel(
    var id: String,
    var author: String,
    var count_comments: String,
    var thumbnailUrl: String?,
    var publication_date: String,
    var fullFileUrl: String?,
    var title : String,
    var isVideo : Boolean

)
