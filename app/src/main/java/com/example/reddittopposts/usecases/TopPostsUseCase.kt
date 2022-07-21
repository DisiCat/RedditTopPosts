package com.example.reddittopposts.usecases

import android.text.format.DateUtils
import android.text.format.DateUtils.FORMAT_ABBREV_RELATIVE
import androidx.paging.*
import com.example.reddittopposts.entities.PostModel
import com.example.reddittopposts.entities.parseModels.ChildData
import com.example.reddittopposts.repositories.ITopPostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.text.ParseException
import javax.inject.Inject

class TopPostsUseCase @Inject constructor(
    private val topPostsRepository: ITopPostsRepository
) : ITopPostsUseCase {

    override fun getRedditData(): Flow<PagingData<PostModel>> {
        return topPostsRepository.getPagedPosts()
            .map { pagingData -> pagingData.map { createPostModel(it.data) } }
    }

    private fun createPostModel(childData: ChildData): PostModel {
        return PostModel(
            id = childData.id ?: "",
            author = childData.subredditNamePrefixed ?: "---",
            count_comments = childData.numComments.toString() ?: "---",
            thumbnailUrl = childData.thumbnail,
            publication_date = getDateTimeFormatted(childData.createdUTC?.toLong()),
            fullFileUrl = if (childData.isVideo == true) {
                childData.media?.reddit_video?.scrubberMediaURL?.replace(
                    "?source=fallback",
                    ""
                )
            } else {
                childData.url
            },
            title = childData.title ?: "---",
            isVideo = childData.isVideo ?: false
        )
    }

    private fun getDateTimeFormatted(publication_time: Long?): String {
        var timeResult = ""
        if (publication_time != null) {
            try {
                val now = System.currentTimeMillis()
                timeResult =
                    DateUtils.getRelativeTimeSpanString(
                        publication_time * 1000,
                        now,
                        DateUtils.MINUTE_IN_MILLIS,
                        FORMAT_ABBREV_RELATIVE
                    )
                        .toString()
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
        return timeResult
    }

}