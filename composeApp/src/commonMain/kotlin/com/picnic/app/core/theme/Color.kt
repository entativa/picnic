package com.picnic.app.core.theme

import androidx.compose.ui.graphics.Color

/**
 * Picnic color system - following UIUX.md specifications
 */
object PicnicColors {
    // Primary Colors - Yellow to Green gradient
    val PrimaryYellow = Color(0xFFF4FF6C)  // #F4FF6C
    val PrimaryGreen = Color(0xFF7CFF6C)   // #7CFF6C
    
    // Neutral Colors - Dark mode first
    val BackgroundDark = Color(0xFF000000)  // #000000
    val SurfaceDark = Color(0xFF1A1A1A)     // #1A1A1A
    val SurfaceLight = Color(0xFF2D2D2D)    // #2D2D2D
    val Border = Color(0xFF3D3D3D)          // #3D3D3D
    
    // Text Colors
    val TextPrimary = Color(0xFFFFFFFF)     // #FFFFFF
    val TextSecondary = Color(0xFFB3B3B3)   // #B3B3B3
    val TextTertiary = Color(0xFF808080)    // #808080
    val TextDisabled = Color(0xFF4D4D4D)    // #4D4D4D
    
    // Accent Colors
    val AccentPink = Color(0xFFFF6BCF)      // #FF6BCF
    val AccentBlue = Color(0xFF6B9FFF)      // #6B9FFF
    val AccentOrange = Color(0xFFFFB56B)    // #FFB56B
    val LiveRed = Color(0xFFFF4444)         // #FF4444
    
    // Semantic Colors
    val Success = Color(0xFF4ADE80)         // #4ADE80
    val Warning = Color(0xFFFBBF24)         // #FBBF24
    val Error = Color(0xFFF87171)           // #F87171
    val Info = Color(0xFF60A5FA)            // #60A5FA
    
    // Light Mode (Optional)
    val BackgroundLight = Color(0xFFFFFFFF)
    val SurfaceLightMode = Color(0xFFF5F5F5)
    val BorderLight = Color(0xFFE0E0E0)
    val TextPrimaryLight = Color(0xFF000000)
    val TextSecondaryLight = Color(0xFF666666)
}
