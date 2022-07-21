package com.example.reddittopposts

import android.os.Build
import android.text.format.DateUtils
import androidx.annotation.RequiresApi
import com.example.reddittopposts.entities.PostModel
import com.example.reddittopposts.entities.parseModels.ChildData
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
/*

internal fun ChildData.toPostModel(): PostModel {
    return PostModel(
        id = id,
        author = subredditNamePrefixed,
        count_comments = numComments,
        image = thumbnail,
        publication_date = DateUtils.getRelativeTimeSpanString(createdUTC.toLong())
    )
}
*/
