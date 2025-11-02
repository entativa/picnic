package com.picnic.app.domain.model

import kotlinx.serialization.Serializable

/**
 * Basket - Collaborative album where friends co-curate content
 */
@Serializable
data class Basket(
    val id: String,
    val name: String,
    val description: String? = null,
    val coverImageUrl: String? = null,
    val creator: UserBasic,
    val isPrivate: Boolean = false,
    val memberCount: Int = 0,
    val postCount: Int = 0,
    val theme: BasketTheme? = null,
    val createdAt: String,
    val updatedAt: String
)

/**
 * Basket theme for customization
 */
@Serializable
data class BasketTheme(
    val backgroundColor: String,
    val textColor: String,
    val accentColor: String
)

/**
 * Basket member with permissions
 */
@Serializable
data class BasketMember(
    val id: String,
    val basketId: String,
    val user: UserBasic,
    val role: BasketRole,
    val joinedAt: String
)

enum class BasketRole {
    OWNER,      // Can manage all aspects
    ADMIN,      // Can add/remove members and posts
    CONTRIBUTOR, // Can add posts
    VIEWER      // Can only view
}

/**
 * Basket invitation
 */
@Serializable
data class BasketInvitation(
    val id: String,
    val basketId: String,
    val basket: Basket,
    val inviter: UserBasic,
    val invitee: UserBasic,
    val role: BasketRole,
    val status: InvitationStatus,
    val createdAt: String,
    val respondedAt: String? = null
)

enum class InvitationStatus {
    PENDING,
    ACCEPTED,
    DECLINED,
    EXPIRED
}
