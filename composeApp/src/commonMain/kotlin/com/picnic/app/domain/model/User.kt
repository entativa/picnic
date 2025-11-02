package com.picnic.app.domain.model

import kotlinx.serialization.Serializable

/**
 * User entity representing a Picnic user
 */
@Serializable
data class User(
    val id: String,
    val username: String,
    val email: String,
    val displayName: String,
    val bio: String? = null,
    val avatarUrl: String? = null,
    val headerImageUrl: String? = null,
    val location: String? = null,
    val website: String? = null,
    val isVerified: Boolean = false,
    val isPrivate: Boolean = false,
    val followerCount: Int = 0,
    val followingCount: Int = 0,
    val postCount: Int = 0,
    val likeCount: Int = 0,
    val createdAt: String,
    val updatedAt: String
)

/**
 * User profile for display purposes (without sensitive info)
 */
@Serializable
data class UserProfile(
    val id: String,
    val username: String,
    val displayName: String,
    val bio: String? = null,
    val avatarUrl: String? = null,
    val headerImageUrl: String? = null,
    val location: String? = null,
    val website: String? = null,
    val isVerified: Boolean = false,
    val isPrivate: Boolean = false,
    val followerCount: Int = 0,
    val followingCount: Int = 0,
    val postCount: Int = 0,
    val likeCount: Int = 0,
    val isFollowing: Boolean = false,
    val isFollowedBy: Boolean = false,
    val isMutualFollow: Boolean = false,
    val createdAt: String
)

/**
 * Minimal user info for mentions, comments, etc.
 */
@Serializable
data class UserBasic(
    val id: String,
    val username: String,
    val displayName: String,
    val avatarUrl: String? = null,
    val isVerified: Boolean = false
)
