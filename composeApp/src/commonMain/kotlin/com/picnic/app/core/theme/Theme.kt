package com.picnic.app.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

/**
 * Dark color scheme (default for Picnic)
 */
private val DarkColorScheme = darkColorScheme(
    primary = PicnicColors.PrimaryYellow,
    onPrimary = PicnicColors.BackgroundDark,
    primaryContainer = PicnicColors.PrimaryGreen,
    onPrimaryContainer = PicnicColors.BackgroundDark,
    
    secondary = PicnicColors.AccentBlue,
    onSecondary = PicnicColors.TextPrimary,
    secondaryContainer = PicnicColors.SurfaceDark,
    onSecondaryContainer = PicnicColors.TextPrimary,
    
    tertiary = PicnicColors.AccentPink,
    onTertiary = PicnicColors.TextPrimary,
    
    background = PicnicColors.BackgroundDark,
    onBackground = PicnicColors.TextPrimary,
    
    surface = PicnicColors.SurfaceDark,
    onSurface = PicnicColors.TextPrimary,
    surfaceVariant = PicnicColors.SurfaceLight,
    onSurfaceVariant = PicnicColors.TextSecondary,
    
    error = PicnicColors.Error,
    onError = PicnicColors.TextPrimary,
    
    outline = PicnicColors.Border,
    outlineVariant = PicnicColors.TextTertiary,
    
    scrim = PicnicColors.BackgroundDark.copy(alpha = 0.8f)
)

/**
 * Light color scheme (optional)
 */
private val LightColorScheme = lightColorScheme(
    primary = PicnicColors.PrimaryYellow,
    onPrimary = PicnicColors.BackgroundDark,
    primaryContainer = PicnicColors.PrimaryGreen,
    onPrimaryContainer = PicnicColors.BackgroundDark,
    
    secondary = PicnicColors.AccentBlue,
    onSecondary = PicnicColors.TextPrimary,
    secondaryContainer = PicnicColors.SurfaceLightMode,
    onSecondaryContainer = PicnicColors.TextPrimaryLight,
    
    tertiary = PicnicColors.AccentPink,
    onTertiary = PicnicColors.TextPrimary,
    
    background = PicnicColors.BackgroundLight,
    onBackground = PicnicColors.TextPrimaryLight,
    
    surface = PicnicColors.BackgroundLight,
    onSurface = PicnicColors.TextPrimaryLight,
    surfaceVariant = PicnicColors.SurfaceLightMode,
    onSurfaceVariant = PicnicColors.TextSecondaryLight,
    
    error = PicnicColors.Error,
    onError = PicnicColors.TextPrimary,
    
    outline = PicnicColors.BorderLight,
    outlineVariant = PicnicColors.TextSecondaryLight
)

/**
 * Picnic theme - Dark mode first design
 */
@Composable
fun PicnicTheme(
    darkTheme: Boolean = true,  // Dark mode is default
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = PicnicTypography,
        content = content
    )
}
