package com.picnic.app.domain.model

import kotlinx.serialization.Serializable

/**
 * Clip - Short-form video content (15-90 seconds)
 */
@Serializable
data class Clip(
    val id: String,
    val author: UserBasic,
    val videoUrl: String,
    val thumbnailUrl: String,
    val caption: String? = null,
    val duration: Int,  // in seconds
    val width: Int,
    val height: Int,
    val audioTrack: AudioTrack? = null,
    val effects: List<ClipEffect> = emptyList(),
    val likeCount: Int = 0,
    val commentCount: Int = 0,
    val shareCount: Int = 0,
    val viewCount: Int = 0,
    val playCount: Int = 0,
    val isLiked: Boolean = false,
    val hashtags: List<String> = emptyList(),
    val mentions: List<UserBasic> = emptyList(),
    val location: Location? = null,
    val originalClipId: String? = null,  // For duets/stitches
    val createdAt: String
)

/**
 * Audio track for clips
 */
@Serializable
data class AudioTrack(
    val id: String,
    val title: String,
    val artist: String,
    val duration: Int,
    val coverUrl: String? = null,
    val audioUrl: String,
    val usageCount: Int = 0
)

/**
 * Effects applied to clips
 */
@Serializable
data class ClipEffect(
    val id: String,
    val name: String,
    val type: EffectType
)

enum class EffectType {
    FILTER,
    TRANSITION,
    STICKER,
    TEXT,
    SPEED,  // slow-mo, time-lapse
    GREEN_SCREEN
}
