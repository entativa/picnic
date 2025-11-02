package com.picnic.app.domain.model

import kotlinx.serialization.Serializable

/**
 * Follow relationship between users
 */
@Serializable
data class Follow(
    val id: String,
    val followerId: String,
    val followingId: String,
    val createdAt: String
)

/**
 * Follow request for private accounts
 */
@Serializable
data class FollowRequest(
    val id: String,
    val requester: UserBasic,
    val targetUser: UserBasic,
    val status: FollowRequestStatus,
    val createdAt: String,
    val respondedAt: String? = null
)

enum class FollowRequestStatus {
    PENDING,
    ACCEPTED,
    REJECTED
}

/**
 * User subscription tier (for creator monetization)
 */
@Serializable
data class SubscriptionTier(
    val id: String,
    val creatorId: String,
    val name: String,
    val description: String,
    val priceMonthly: Double,  // in USD
    val perks: List<String>,
    val isActive: Boolean = true,
    val subscriberCount: Int = 0,
    val createdAt: String,
    val updatedAt: String
)

/**
 * User subscription to a creator
 */
@Serializable
data class Subscription(
    val id: String,
    val subscriberId: String,
    val creatorId: String,
    val tierId: String,
    val status: SubscriptionStatus,
    val startedAt: String,
    val expiresAt: String,
    val autoRenew: Boolean = true
)

enum class SubscriptionStatus {
    ACTIVE,
    CANCELLED,
    EXPIRED,
    PAUSED
}

/**
 * Creator analytics
 */
@Serializable
data class CreatorAnalytics(
    val userId: String,
    val period: AnalyticsPeriod,
    val totalViews: Long,
    val totalLikes: Long,
    val totalComments: Long,
    val totalShares: Long,
    val followerGrowth: Int,
    val engagementRate: Double,
    val topPosts: List<Post>,
    val audienceDemographics: AudienceDemographics,
    val revenue: Revenue? = null
)

enum class AnalyticsPeriod {
    DAY,
    WEEK,
    MONTH,
    YEAR,
    ALL_TIME
}

/**
 * Audience demographics
 */
@Serializable
data class AudienceDemographics(
    val ageGroups: Map<String, Int>,
    val genderDistribution: Map<String, Int>,
    val topCountries: Map<String, Int>,
    val topCities: Map<String, Int>
)

/**
 * Revenue information for creators
 */
@Serializable
data class Revenue(
    val totalEarnings: Double,
    val subscriptionRevenue: Double,
    val tipRevenue: Double,
    val pendingPayout: Double,
    val lastPayoutDate: String? = null,
    val nextPayoutDate: String
)
