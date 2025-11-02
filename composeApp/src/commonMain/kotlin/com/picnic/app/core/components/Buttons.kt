package com.picnic.app.core.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.picnic.app.core.theme.PicnicColors

/**
 * Primary button with gradient background
 * Following UIUX.md specifications
 */
@Composable
fun PicnicPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = tween(150)
    )
    
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(
            PicnicColors.PrimaryYellow,
            PicnicColors.PrimaryGreen
        )
    )
    
    Box(
        modifier = modifier
            .height(56.dp)
            .scale(scale)
            .clip(RoundedCornerShape(28.dp))
            .background(
                brush = if (enabled) gradientBrush else Brush.linearGradient(
                    colors = listOf(
                        PicnicColors.TextDisabled,
                        PicnicColors.TextDisabled
                    )
                ),
                alpha = if (enabled) 1f else 0.4f
            )
            .clickable(
                enabled = enabled && !isLoading,
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    isPressed = true
                    onClick()
                }
            )
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = PicnicColors.BackgroundDark,
                strokeWidth = 2.dp
            )
        } else {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = PicnicColors.BackgroundDark
            )
        }
    }
    
    LaunchedEffect(isPressed) {
        if (isPressed) {
            kotlinx.coroutines.delay(150)
            isPressed = false
        }
    }
}

/**
 * Secondary button with transparent background and border
 */
@Composable
fun PicnicSecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = tween(150)
    )
    
    OutlinedButton(
        onClick = {
            isPressed = true
            onClick()
        },
        modifier = modifier
            .height(56.dp)
            .scale(scale),
        enabled = enabled,
        shape = RoundedCornerShape(28.dp),
        border = androidx.compose.foundation.BorderStroke(
            width = 2.dp,
            color = if (enabled) PicnicColors.Border else PicnicColors.TextDisabled
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = PicnicColors.TextPrimary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = PicnicColors.TextDisabled
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold
            )
        )
    }
    
    LaunchedEffect(isPressed) {
        if (isPressed) {
            kotlinx.coroutines.delay(150)
            isPressed = false
        }
    }
}

/**
 * Icon button with circular background
 */
@Composable
fun PicnicIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .size(44.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(PicnicColors.SurfaceLight)
            .clickable(
                enabled = enabled,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

/**
 * Text button (no background, just text)
 */
@Composable
fun PicnicTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(
            contentColor = PicnicColors.TextPrimary,
            disabledContentColor = PicnicColors.TextDisabled
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium
            )
        )
    }
}
