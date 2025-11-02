package com.picnic.app.domain.model

import kotlinx.serialization.Serializable

/**
 * Post types in Picnic's hybrid feed
 */
enum class PostType {
    TEXT,           // Text-only post
    IMAGE,          // Image post (1-10 images)
    VIDEO,          // Video post
    CLIP,           // Short-form video (15-90s)
    POLL,           // Poll post
    SHARED          // Shared/reposted content
}

/**
 * Media attachment for posts
 */
@Serializable
data class MediaAttachment(
    val id: String,
    val url: String,
    val thumbnailUrl: String? = null,
    val type: MediaType,
    val width: Int? = null,
    val height: Int? = null,
    val duration: Int? = null,  // in seconds for video/clip
    val aspectRatio: String? = null,  // e.g., "1:1", "4:5", "16:9"
    val blurHash: String? = null  // for progressive image loading
)

enum class MediaType {
    IMAGE,
    VIDEO,
    CLIP
}

/**
 * Post entity in the hybrid feed
 */
@Serializable
data class Post(
    val id: String,
    val author: UserBasic,
    val type: PostType,
    val content: String? = null,
    val mediaAttachments: List<MediaAttachment> = emptyList(),
    val likeCount: Int = 0,
    val commentCount: Int = 0,
    val shareCount: Int = 0,
    val viewCount: Int = 0,
    val bookmarkCount: Int = 0,
    val isLiked: Boolean = false,
    val isBookmarked: Boolean = false,
    val location: Location? = null,
    val hashtags: List<String> = emptyList(),
    val mentions: List<UserBasic> = emptyList(),
    val sharedPost: Post? = null,  // For shared content
    val createdAt: String,
    val updatedAt: String
)

/**
 * Location tag for posts
 */
@Serializable
data class Location(
    val id: String,
    val name: String,
    val address: String? = null,
    val latitude: Double,
    val longitude: Double
)

/**
 * Comment on a post
 */
@Serializable
data class Comment(
    val id: String,
    val postId: String,
    val author: UserBasic,
    val content: String,
    val likeCount: Int = 0,
    val replyCount: Int = 0,
    val isLiked: Boolean = false,
    val parentCommentId: String? = null,  // For threaded comments
    val mentions: List<UserBasic> = emptyList(),
    val createdAt: String,
    val updatedAt: String
)

/**
 * Like on a post or comment
 */
@Serializable
data class Like(
    val id: String,
    val userId: String,
    val targetId: String,  // Post or Comment ID
    val targetType: LikeTargetType,
    val createdAt: String
)

enum class LikeTargetType {
    POST,
    COMMENT
}
