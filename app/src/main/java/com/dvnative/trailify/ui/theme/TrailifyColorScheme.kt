package com.dvnative.trailify.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import com.dvnative.trailify.ui.tokens.Violet
import com.dvnative.trailify.ui.tokens.VioletBright
import com.dvnative.trailify.ui.tokens.VioletLight
import com.dvnative.trailify.ui.tokens.VioletNight
import com.dvnative.trailify.ui.tokens.White06
import com.dvnative.trailify.ui.tokens.White100


val TrailifyColorScheme = DesignSystemColors(
    material = ColorScheme(
        primary = VioletNight,
        onPrimary = Gray100, //primaryActiveButton text color (Color used for text and icons displayed on top of the primary color.)
        primaryContainer = RedFocus, //primaryActiveButton background, (The preferred tonal color of containers)
        onPrimaryContainer = BluePrimary, //primaryEditText background color
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
    backgroundGradient = Brush.horizontalGradient(
        colorStops = arrayOf(
            0.0f to DarkBlue,
            0.5f to BlueVariant,
            1.0f to DarkBlue
        )
    ),
    backgroundGradientVariant = Brush.horizontalGradient(
        colorStops = arrayOf(
            0.0f to DarkBlue,
            0.25f to DarkBlue,
            0.5f to BlueVariant,
            0.75f to DarkBlue,
            1.0f to DarkBlue
        )
    )

)



//.also {
//    it.extraColors.disabledContainer = White06
//    it.extraColors.onDisabled = BlueFocus
//    it.extraColors.backgroundGradient = Brush.horizontalGradient(
//        colorStops = arrayOf(
//            0.0f to DarkBlue,
//            0.5f to BlueVariant,
//            1.0f to DarkBlue
//        )
//    )
//    it.extraColors.backgroundGradientVariant = Brush.horizontalGradient(
//        colorStops = arrayOf(
//            0.0f to DarkBlue,
//            0.25f to DarkBlue,
//            0.5f to BlueVariant,
//            0.75f to DarkBlue,
//            1.0f to DarkBlue
//        )
//    )
//}