package com.example.reddittopposts.entities

import com.squareup.moshi.Json

data class ChildData(
    @Json(name = "approved_at_utc")
    val approvedAtUTC: Any? = null,

    val subreddit: String,
    val selftext: String,

    @Json(name = "author_fullname")
    val authorFullname: String,

    val saved: Boolean,

    @Json(name = "mod_reason_title")
    val modReasonTitle: Any? = null,

    val gilded: Long,
    val clicked: Boolean,
    val title: String,

    @Json(name = "link_flair_richtext")
    val linkFlairRichtext: List<Any?>,

    @Json(name = "subreddit_name_prefixed")
    val subredditNamePrefixed: String,

    val hidden: Boolean,
    val pwls: Long,

    @Json(name = "link_flair_css_class")
    val linkFlairCSSClass: Any? = null,

    val downs: Long,

    @Json(name = "thumbnail_height")
    val thumbnailHeight: Any? = null,

    @Json(name = "top_awarded_type")
    val topAwardedType: Any? = null,

    @Json(name = "hide_score")
    val hideScore: Boolean,

    val name: String,
    val quarantine: Boolean,

    @Json(name = "link_flair_text_color")
    val linkFlairTextColor: String,

    @Json(name = "upvote_ratio")
    val upvoteRatio: Double,

    @Json(name = "author_flair_background_color")
    val authorFlairBackgroundColor: Any? = null,

    @Json(name = "subreddit_type")
    val subredditType: String,

    val ups: Long,

    @Json(name = "total_awards_received")
    val totalAwardsReceived: Long,

    @Json(name = "thumbnail_width")
    val thumbnailWidth: Any? = null,

    @Json(name = "author_flair_template_id")
    val authorFlairTemplateID: Any? = null,

    @Json(name = "is_original_content")
    val isOriginalContent: Boolean,

    @Json(name = "user_reports")
    val userReports: List<Any?>,

    @Json(name = "secure_media")
    val secureMedia: Any? = null,

    @Json(name = "is_reddit_media_domain")
    val isRedditMediaDomain: Boolean,

    @Json(name = "is_meta")
    val isMeta: Boolean,

    val category: Any? = null,

    @Json(name = "link_flair_text")
    val linkFlairText: Any? = null,

    @Json(name = "can_mod_post")
    val canModPost: Boolean,

    val score: Long,

    @Json(name = "approved_by")
    val approvedBy: Any? = null,

    @Json(name = "is_created_from_ads_ui")
    val isCreatedFromAdsUI: Boolean,

    @Json(name = "author_premium")
    val authorPremium: Boolean,

    val thumbnail: String,
    val edited: Boolean,

    @Json(name = "author_flair_css_class")
    val authorFlairCSSClass: Any? = null,

    @Json(name = "author_flair_richtext")
    val authorFlairRichtext: List<Any?>,

    @Json(name = "content_categories")
    val contentCategories: Any? = null,

    @Json(name = "is_self")
    val isSelf: Boolean,

    @Json(name = "mod_note")
    val modNote: Any? = null,

    val created: Double,

    @Json(name = "link_flair_type")
    val linkFlairType: String,

    val wls: Long,

    @Json(name = "removed_by_category")
    val removedByCategory: Any? = null,

    @Json(name = "banned_by")
    val bannedBy: Any? = null,

    @Json(name = "author_flair_type")
    val authorFlairType: String,

    val domain: String,

    @Json(name = "allow_live_comments")
    val allowLiveComments: Boolean,

    @Json(name = "selftext_html")
    val selftextHTML: String,

    val likes: Any? = null,

    @Json(name = "suggested_sort")
    val suggestedSort: Any? = null,

    @Json(name = "banned_at_utc")
    val bannedAtUTC: Any? = null,

    @Json(name = "view_count")
    val viewCount: Any? = null,

    val archived: Boolean,

    @Json(name = "no_follow")
    val noFollow: Boolean,

    @Json(name = "is_crosspostable")
    val isCrosspostable: Boolean,

    val pinned: Boolean,

    @Json(name = "over_18")
    val over18: Boolean,

    @Json(name = "all_awardings")
    val allAwardings: List<Any?>,

    val awarders: List<Any?>,

    @Json(name = "media_only")
    val mediaOnly: Boolean,

    @Json(name = "can_gild")
    val canGild: Boolean,

    val spoiler: Boolean,
    val locked: Boolean,

    @Json(name = "author_flair_text")
    val authorFlairText: Any? = null,

    @Json(name = "treatment_tags")
    val treatmentTags: List<Any?>,

    val visited: Boolean,

    @Json(name = "removed_by")
    val removedBy: Any? = null,

    @Json(name = "num_reports")
    val numReports: Any? = null,

    val distinguished: Any? = null,

    @Json(name = "subreddit_id")
    val subredditID: String,

    @Json(name = "author_is_blocked")
    val authorIsBlocked: Boolean,

    @Json(name = "mod_reason_by")
    val modReasonBy: Any? = null,

    @Json(name = "removal_reason")
    val removalReason: Any? = null,

    @Json(name = "link_flair_background_color")
    val linkFlairBackgroundColor: String,

    val id: String,

    @Json(name = "is_robot_indexable")
    val isRobotIndexable: Boolean,

    @Json(name = "report_reasons")
    val reportReasons: Any? = null,

    val author: String,

    @Json(name = "discussion_type")
    val discussionType: Any? = null,

    @Json(name = "num_comments")
    val numComments: Long,

    @Json(name = "send_replies")
    val sendReplies: Boolean,

    @Json(name = "whitelist_status")
    val whitelistStatus: String,

    @Json(name = "contest_mode")
    val contestMode: Boolean,

    @Json(name = "mod_reports")
    val modReports: List<Any?>,

    @Json(name = "author_patreon_flair")
    val authorPatreonFlair: Boolean,

    @Json(name = "author_flair_text_color")
    val authorFlairTextColor: Any? = null,

    val permalink: String,

    @Json(name = "parent_whitelist_status")
    val parentWhitelistStatus: String,

    val stickied: Boolean,
    val url: String,

    @Json(name = "subreddit_subscribers")
    val subredditSubscribers: Long,

    @Json(name = "created_utc")
    val createdUTC: Double,

    @Json(name = "num_crossposts")
    val numCrossposts: Long,

    val media: Any? = null,

    @Json(name = "is_video")
    val isVideo: Boolean
)
