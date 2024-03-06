package com.dvnative.trailify.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dvnative.trailify.ui.tokens.Black30
import com.dvnative.trailify.ui.tokens.Black60
import com.dvnative.trailify.ui.tokens.BlueNight
import com.dvnative.trailify.ui.tokens.Gray100
import com.dvnative.trailify.ui.tokens.Gray400
import com.dvnative.trailify.ui.tokens.Gray700
import com.dvnative.trailify.ui.tokens.Red
import com.dvnative.trailify.ui.tokens.SizeTokens
import com.dvnative.trailify.ui.tokens.Violet
import com.dvnative.trailify.ui.tokens.VioletBright
import com.dvnative.trailify.ui.tokens.VioletLight
import com.dvnative.trailify.ui.tokens.VioletNight
import com.dvnative.trailify.ui.tokens.White06
import com.dvnative.trailify.ui.tokens.White100

val PlayupDesignSystem = DesignSystem(
    splashVideo = true,
    material = ColorScheme(
        primary = VioletNight,
        onPrimary = Gray100, //primaryActiveButton text color (Color used for text and icons displayed on top of the primary color.)
        primaryContainer = Violet, //primaryActiveButton background, (The preferred tonal color of containers)
        onPrimaryContainer = Black30, //primaryEditText background color
        inversePrimary = Black30,
        secondary = VioletBright,
        onSecondary = Gray700, //secondaryButton text color
        secondaryContainer = Gray100, //secondaryButton Background
        onSecondaryContainer = Black30,
        tertiary = VioletLight,
        onTertiary = Gray100, //outlineButton text
        tertiaryContainer = Color.Transparent, //outlineButton Background,
        onTertiaryContainer = Color.Transparent, //outlineButton Background
        background = Black30,
        onBackground = Black30,
        surface = BlueNight,
        onSurface = Gray100, //text on main background
        surfaceVariant = Black30,
        onSurfaceVariant = Black30,
        surfaceTint = Black30,
        inverseSurface = Black30,
        inverseOnSurface = Black30,
        error = Red,
        onError = Red, //error
        errorContainer = Black30,
        onErrorContainer = Black30, //errorEditText background,
        outline = Gray400,
        outlineVariant = Black30,
        scrim = Black30
    ),
    disabledContainer = White06,
    onDisabled = Gray400,
    backgroundGradient = Brush.horizontalGradient(
        colorStops = arrayOf(
            0.0f to BlueNight,
            0.5f to VioletNight,
            1.0f to BlueNight
        )
    ),
    backgroundGradientVariant = Brush.horizontalGradient(
        colorStops = arrayOf(
            0.0f to BlueNight,
            0.25f to BlueNight,
            0.5f to VioletNight,
            0.75f to BlueNight,
            1.0f to BlueNight
        )
    ),
    sizes = SizeTokens(
        labelPadding = 14.dp,
        editTextOutlineBorder = 1.dp,
        buttonOutlineBorder = 1.dp,
        textFieldBorderRadius = 5.dp,
        buttonsBorderRadius = 5.dp,
        containerHorizontalPadding = 10.dp,
        titleVerticalPadding = 20.dp
    ),
    splashPrimary = Violet,
    splashContainer = White100
)