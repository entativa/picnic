package com.picnic.app.domain.model

import kotlinx.serialization.Serializable

/**
 * Hangout - Community group for shared interests
 */
@Serializable
data class Hangout(
    val id: String,
    val name: String,
    val description: String,
    val avatarUrl: String? = null,
    val coverImageUrl: String? = null,
    val category: HangoutCategory,
    val isPrivate: Boolean = false,
    val memberCount: Int = 0,
    val postCount: Int = 0,
    val rules: List<String> = emptyList(),
    val createdBy: UserBasic,
    val createdAt: String,
    val updatedAt: String
)

enum class HangoutCategory {
    MUSIC,
    ART,
    GAMING,
    SPORTS,
    FOOD,
    TRAVEL,
    FASHION,
    TECHNOLOGY,
    EDUCATION,
    BUSINESS,
    HEALTH,
    ENTERTAINMENT,
    OTHER
}

/**
 * Hangout member with role
 */
@Serializable
data class HangoutMember(
    val id: String,
    val hangoutId: String,
    val user: UserBasic,
    val role: HangoutRole,
    val joinedAt: String
)

enum class HangoutRole {
    OWNER,
    MODERATOR,
    MEMBER
}

/**
 * Join request for private hangouts
 */
@Serializable
data class HangoutJoinRequest(
    val id: String,
    val hangoutId: String,
    val user: UserBasic,
    val message: String? = null,
    val status: JoinRequestStatus,
    val createdAt: String,
    val respondedAt: String? = null,
    val respondedBy: UserBasic? = null
)

enum class JoinRequestStatus {
    PENDING,
    APPROVED,
    REJECTED
}

/**
 * Hangout event
 */
@Serializable
data class HangoutEvent(
    val id: String,
    val hangoutId: String,
    val title: String,
    val description: String,
    val startTime: String,
    val endTime: String? = null,
    val location: Location? = null,
    val isOnline: Boolean = false,
    val attendeeCount: Int = 0,
    val createdBy: UserBasic,
    val createdAt: String
)
