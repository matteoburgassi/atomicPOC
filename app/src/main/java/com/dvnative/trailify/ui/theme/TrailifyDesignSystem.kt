package com.dvnative.trailify.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dvnative.trailify.ui.tokens.Black30
import com.dvnative.trailify.ui.tokens.BluePrimary
import com.dvnative.trailify.ui.tokens.Gray100
import com.dvnative.trailify.ui.tokens.BlueFocus
import com.dvnative.trailify.ui.tokens.BlueNight
import com.dvnative.trailify.ui.tokens.BlueVariant
import com.dvnative.trailify.ui.tokens.DarkBlue
import com.dvnative.trailify.ui.tokens.Gray700
import com.dvnative.trailify.ui.tokens.RedError
import com.dvnative.trailify.ui.tokens.RedFocus
import com.dvnative.trailify.ui.tokens.SizeTokens
import com.dvnative.trailify.ui.tokens.UltraDarkBlue
import com.dvnative.trailify.ui.tokens.VioletLight
import com.dvnative.trailify.ui.tokens.VioletNight
import com.dvnative.trailify.ui.tokens.White06
import com.dvnative.trailify.ui.tokens.White100


val TrailifyDesignSystem = DesignSystem(
    material = ColorScheme(
        primary = VioletNight,
        onPrimary = Gray100, //primaryActiveButton text color (Color used for text and icons displayed on top of the primary color.)
        primaryContainer = RedFocus, //primaryActiveButton background, (The preferred tonal color of containers)
        onPrimaryContainer = BluePrimary, //primaryEditText background color
        inversePrimary = Black30,
        secondary = BlueFocus,
        onSecondary = Gray700, //secondaryButton text color
        secondaryContainer = Gray100, //secondaryButton Background
        onSecondaryContainer = Black30,
        tertiary = VioletLight,
        onTertiary = Gray100, //outlineButton text
        tertiaryContainer = Color.Transparent, //outlineButton Background,
        onTertiaryContainer = Color.Transparent, //outlineButton Background
        background = Black30,
        onBackground = UltraDarkBlue,
        surface = White100,
        onSurface = Gray100, //text on main background
        surfaceVariant = BlueNight,
        onSurfaceVariant = Black30,
        surfaceTint = Black30,
        inverseSurface = Black30,
        inverseOnSurface = Black30,
        error = RedError,
        onError = RedError, //error
        errorContainer = BluePrimary,
        onErrorContainer = BluePrimary, //errorEditText background,
        outline = BlueFocus,
        outlineVariant = Black30,
        scrim = Black30
    ),
    disabledContainer = White06,
    onDisabled = Gray100,
    backgroundGradient = Brush.linearGradient(
        colorStops = arrayOf(
            0.0f to BlueVariant,
            0.7f to DarkBlue
        ),
        start = Offset.Zero,
        end = Offset.Infinite

    ),
    backgroundGradientVariant = Brush.linearGradient(
        colorStops = arrayOf(
            0.0f to BlueVariant,
            0.7f to DarkBlue,
        ),
        start = Offset.Zero,
        end = Offset.Infinite
    ),
    splashVideo = false,
    sizes = SizeTokens(
        labelPadding = 14.dp,
        editTextOutlineBorder = 1.dp,
        buttonOutlineBorder = 1.dp,
        textFieldBorderRadius = 5.dp,
        buttonsBorderRadius = 5.dp,
        containerHorizontalPadding = 10.dp,
        titleVerticalPadding = 20.dp
    ),
    splashContainer = Color.White,
    splashPrimary = BlueVariant
    )