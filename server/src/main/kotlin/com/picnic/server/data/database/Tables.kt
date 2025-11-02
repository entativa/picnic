package com.picnic.server.data.database

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

/**
 * Users table - stores user account information
 */
object Users : UUIDTable("users") {
    val email = varchar("email", 255).uniqueIndex()
    val username = varchar("username", 50).uniqueIndex()
    val passwordHash = varchar("password_hash", 255)
    val displayName = varchar("display_name", 100)
    val bio = text("bio").nullable()
    val avatarUrl = varchar("avatar_url", 500).nullable()
    val headerImageUrl = varchar("header_image_url", 500).nullable()
    val location = varchar("location", 100).nullable()
    val website = varchar("website", 255).nullable()
    val isVerified = bool("is_verified").default(false)
    val isPrivate = bool("is_private").default(false)
    val emailVerified = bool("email_verified").default(false)
    val followerCount = integer("follower_count").default(0)
    val followingCount = integer("following_count").default(0)
    val postCount = integer("post_count").default(0)
    val likeCount = integer("like_count").default(0)
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    val updatedAt = datetime("updated_at").clientDefault { LocalDateTime.now() }
    val lastLoginAt = datetime("last_login_at").nullable()
}

/**
 * Refresh tokens table - stores JWT refresh tokens
 */
object RefreshTokens : UUIDTable("refresh_tokens") {
    val userId = reference("user_id", Users)
    val token = varchar("token", 500).uniqueIndex()
    val expiresAt = datetime("expires_at")
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    val isRevoked = bool("is_revoked").default(false)
}

/**
 * Email verification tokens
 */
object EmailVerificationTokens : UUIDTable("email_verification_tokens") {
    val userId = reference("user_id", Users)
    val token = varchar("token", 255).uniqueIndex()
    val expiresAt = datetime("expires_at")
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    val isUsed = bool("is_used").default(false)
}

/**
 * Password reset tokens
 */
object PasswordResetTokens : UUIDTable("password_reset_tokens") {
    val userId = reference("user_id", Users)
    val token = varchar("token", 255).uniqueIndex()
    val expiresAt = datetime("expires_at")
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    val isUsed = bool("is_used").default(false)
}

/**
 * Posts table
 */
object Posts : UUIDTable("posts") {
    val authorId = reference("author_id", Users)
    val type = varchar("type", 20)
    val content = text("content").nullable()
    val likeCount = integer("like_count").default(0)
    val commentCount = integer("comment_count").default(0)
    val shareCount = integer("share_count").default(0)
    val viewCount = integer("view_count").default(0)
    val bookmarkCount = integer("bookmark_count").default(0)
    val locationId = uuid("location_id").nullable()
    val sharedPostId = uuid("shared_post_id").nullable()
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    val updatedAt = datetime("updated_at").clientDefault { LocalDateTime.now() }
    val isDeleted = bool("is_deleted").default(false)
}

/**
 * Media attachments table
 */
object MediaAttachments : UUIDTable("media_attachments") {
    val postId = reference("post_id", Posts)
    val url = varchar("url", 500)
    val thumbnailUrl = varchar("thumbnail_url", 500).nullable()
    val type = varchar("type", 20)
    val width = integer("width").nullable()
    val height = integer("height").nullable()
    val duration = integer("duration").nullable()
    val aspectRatio = varchar("aspect_ratio", 10).nullable()
    val blurHash = varchar("blur_hash", 100).nullable()
    val order = integer("order").default(0)
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
}

/**
 * Follows table
 */
object Follows : UUIDTable("follows") {
    val followerId = reference("follower_id", Users)
    val followingId = reference("following_id", Users)
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    
    init {
        uniqueIndex(followerId, followingId)
    }
}

/**
 * Follow requests table (for private accounts)
 */
object FollowRequests : UUIDTable("follow_requests") {
    val requesterId = reference("requester_id", Users)
    val targetUserId = reference("target_user_id", Users)
    val status = varchar("status", 20).default("PENDING")
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    val respondedAt = datetime("responded_at").nullable()
    
    init {
        uniqueIndex(requesterId, targetUserId)
    }
}

/**
 * Likes table
 */
object Likes : UUIDTable("likes") {
    val userId = reference("user_id", Users)
    val targetId = uuid("target_id")
    val targetType = varchar("target_type", 20)
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    
    init {
        uniqueIndex(userId, targetId, targetType)
    }
}

/**
 * Comments table
 */
object Comments : UUIDTable("comments") {
    val postId = reference("post_id", Posts)
    val authorId = reference("author_id", Users)
    val content = text("content")
    val likeCount = integer("like_count").default(0)
    val replyCount = integer("reply_count").default(0)
    val parentCommentId = uuid("parent_comment_id").nullable()
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    val updatedAt = datetime("updated_at").clientDefault { LocalDateTime.now() }
    val isDeleted = bool("is_deleted").default(false)
}

/**
 * Bookmarks table
 */
object Bookmarks : UUIDTable("bookmarks") {
    val userId = reference("user_id", Users)
    val postId = reference("post_id", Posts)
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    
    init {
        uniqueIndex(userId, postId)
    }
}
