package com.picnic.app.domain.model

import kotlinx.serialization.Serializable

/**
 * Story - 24-hour ephemeral content
 */
@Serializable
data class Story(
    val id: String,
    val author: UserBasic,
    val mediaUrl: String,
    val thumbnailUrl: String? = null,
    val type: StoryMediaType,
    val duration: Int = 5,  // seconds to display
    val viewCount: Int = 0,
    val replyCount: Int = 0,
    val isViewed: Boolean = false,
    val createdAt: String,
    val expiresAt: String
)

enum class StoryMediaType {
    IMAGE,
    VIDEO
}

/**
 * Story highlight - Permanent story collection
 */
@Serializable
data class StoryHighlight(
    val id: String,
    val userId: String,
    val title: String,
    val coverImageUrl: String,
    val storyCount: Int = 0,
    val createdAt: String,
    val updatedAt: String
)

/**
 * Story reply
 */
@Serializable
data class StoryReply(
    val id: String,
    val storyId: String,
    val author: UserBasic,
    val content: String,
    val createdAt: String
)

/**
 * Direct message
 */
@Serializable
data class DirectMessage(
    val id: String,
    val conversationId: String,
    val sender: UserBasic,
    val content: String? = null,
    val mediaAttachment: MediaAttachment? = null,
    val replyToMessageId: String? = null,
    val isRead: Boolean = false,
    val isEdited: Boolean = false,
    val isDeleted: Boolean = false,
    val reactions: List<MessageReaction> = emptyList(),
    val createdAt: String,
    val updatedAt: String? = null
)

/**
 * Message conversation (DM or Group)
 */
@Serializable
data class Conversation(
    val id: String,
    val type: ConversationType,
    val participants: List<UserBasic>,
    val lastMessage: DirectMessage? = null,
    val unreadCount: Int = 0,
    val isMuted: Boolean = false,
    val groupName: String? = null,
    val groupAvatarUrl: String? = null,
    val createdAt: String,
    val updatedAt: String
)

enum class ConversationType {
    DIRECT,  // 1-on-1
    GROUP    // Multiple participants
}

/**
 * Message reaction
 */
@Serializable
data class MessageReaction(
    val emoji: String,
    val user: UserBasic,
    val createdAt: String
)

/**
 * Notification
 */
@Serializable
data class Notification(
    val id: String,
    val type: NotificationType,
    val actor: UserBasic,  // Who triggered the notification
    val targetId: String? = null,  // Post, Comment, etc.
    val message: String,
    val isRead: Boolean = false,
    val createdAt: String
)

enum class NotificationType {
    LIKE,
    COMMENT,
    FOLLOW,
    MENTION,
    REPLY,
    BASKET_INVITATION,
    HANGOUT_INVITATION,
    MESSAGE,
    STORY_REPLY,
    SUBSCRIPTION
}
