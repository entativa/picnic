package com.picnic.app.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Picnic typography system - following UIUX.md specifications
 */
val PicnicTypography = Typography(
    // Headings
    displayLarge = TextStyle(
        fontSize = 32.sp,      // Heading XL
        lineHeight = 40.sp,
        fontWeight = FontWeight.Bold
    ),
    displayMedium = TextStyle(
        fontSize = 24.sp,      // Heading L
        lineHeight = 32.sp,
        fontWeight = FontWeight.Bold
    ),
    displaySmall = TextStyle(
        fontSize = 20.sp,      // Heading M
        lineHeight = 28.sp,
        fontWeight = FontWeight.SemiBold
    ),
    headlineLarge = TextStyle(
        fontSize = 18.sp,      // Heading S
        lineHeight = 24.sp,
        fontWeight = FontWeight.SemiBold
    ),
    
    // Body Text
    bodyLarge = TextStyle(
        fontSize = 16.sp,      // Body L
        lineHeight = 24.sp,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,      // Body M
        lineHeight = 20.sp,
        fontWeight = FontWeight.Normal
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,      // Body S
        lineHeight = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    
    // Labels
    labelLarge = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Medium
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    labelSmall = TextStyle(
        fontSize = 11.sp,      // Caption
        lineHeight = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    
    // Titles
    titleLarge = TextStyle(
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.SemiBold
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.SemiBold
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.SemiBold
    )
)
