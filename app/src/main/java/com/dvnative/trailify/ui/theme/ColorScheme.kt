package com.dvnative.trailify.ui.theme

import android.provider.CalendarContract
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.dvnative.trailify.ui.tokens.Gray400
import com.dvnative.trailify.ui.tokens.White06

/*
*
A color scheme holds all the named color parameters for a MaterialTheme.
Color schemes are designed to be harmonious, ensure accessible text, and distinguish UI elements and surfaces from one another. There are two built-in baseline schemes, lightColorScheme and a darkColorScheme, that can be used as-is or customized.
The Material color system and custom schemes provide default values for color as a starting point for customization.
To learn more about colors, see Material Design colors .
*
*
*
primary - The primary color is the color displayed most frequently across your app’s screens and components.
onPrimary - Color used for text and icons displayed on top of the primary color.
primaryContainer - The preferred tonal color of containers.
onPrimaryContainer - The color (and state variants) that should be used for content on top of primaryContainer.
inversePrimary - Color to be used as a "primary" color in places where the inverse color scheme is needed, such as the button on a SnackBar.
secondary -
The secondary color provides more ways to accent and distinguish your product. Secondary colors are best for:
Floating action buttons
Selection controls, like checkboxes and radio buttons
Highlighting selected text
Links and headlines
onSecondary - Color used for text and icons displayed on top of the secondary color.
secondaryContainer - A tonal color to be used in containers.
onSecondaryContainer - The color (and state variants) that should be used for content on top of secondaryContainer.
tertiary - The tertiary color that can be used to balance primary and secondary colors, or bring heightened attention to an element such as an input field.
onTertiary - Color used for text and icons displayed on top of the tertiary color.
tertiaryContainer - A tonal color to be used in containers.
onTertiaryContainer - The color (and state variants) that should be used for content on top of tertiaryContainer.
background - The background color that appears behind scrollable content.
onBackground - Color used for text and icons displayed on top of the background color.
surface - The surface color that affect surfaces of components, such as cards, sheets, and menus.
onSurface - Color used for text and icons displayed on top of the surface color.
surfaceVariant - Another option for a color with similar uses of surface.
onSurfaceVariant - The color (and state variants) that can be used for content on top of surface.
surfaceTint - This color will be used by components that apply tonal elevation and is applied on top of surface. The higher the elevation the more this color is used.
inverseSurface - A color that contrasts sharply with surface. Useful for surfaces that sit on top of other surfaces with surface color.
inverseOnSurface - A color that contrasts well with inverseSurface. Useful for content that sits on top of containers that are inverseSurface.
error - The error color is used to indicate errors in components, such as invalid text in a text field.
onError - Color used for text and icons displayed on top of the error color.
errorContainer - The preferred tonal color of error containers.
onErrorContainer - The color (and state variants) that should be used for content on top of errorContainer.
outline - Subtle color used for boundaries. Outline color role adds contrast for accessibility purposes.
outlineVariant - Utility color used for boundaries for decorative elements when strong contrast is not required.
*
*
*
*
*/

data class DesignSystemColors(
    val material: ColorScheme,
    val disabledContainer: Color,
    val onDisabled: Color,
    val backgroundGradient: Brush,
    val backgroundGradientVariant: Brush
) {
    val primary: Color get() = material.primary
    val onPrimary: Color get() = material.onPrimary
    val primaryContainer: Color get() = material.primaryContainer
    val onPrimaryContainer: Color get() = material.onPrimaryContainer
    val inversePrimary: Color get() = material.inversePrimary
    val secondary: Color get() = material.secondary
    val onSecondary: Color get() = material.onSecondary
    val secondaryContainer: Color get() = material.secondaryContainer
    val onSecondaryContainer: Color get() = material.onSecondaryContainer
    val tertiary: Color get() = material.tertiary
    val onTertiary: Color get() = material.onTertiary
    val tertiaryContainer: Color get() = material.tertiaryContainer
    val onTertiaryContainer: Color get() = material.onTertiaryContainer
    val background: Color get() = material.background
    val onBackground: Color get() = material.onBackground
    val surface: Color get() = material.surface
    val onSurface: Color get() = material.onSurface
    val surfaceVariant: Color get() = material.surfaceVariant
    val onSurfaceVariant: Color get() = material.onSurfaceVariant
    val surfaceTint: Color get() = material.surfaceTint
    val inverseSurface: Color get() = material.inverseSurface
    val inverseOnSurface: Color get() = material.inverseOnSurface
    val error: Color get() = material.error
    val onError: Color get() = material.onError
    val errorContainer: Color get() = material.errorContainer
    val onErrorContainer: Color get() = material.onErrorContainer
    val outline: Color get() = material.outline
    val outlineVariant: Color get() = material.outlineVariant
    val scrim: Color get() = material.scrim

}






//    var extraColors: ExtraColors = ExtraColors()
//        class ExtraColors {
//            var
//            var onDisabled = Gray400
//            var backgroundGradient = Brush.horizontalGradient(
//                colorStops = arrayOf(
//                    0.0f to Color.Black,  //MaterialTheme.colorScheme.background
//                    0.5f to Color.DarkGray,
//                    1.0f to Color.Black   //MaterialTheme.colorScheme.background
//                )
//            )
//            var backgroundGradientVariant = Brush.horizontalGradient(
//                colorStops = arrayOf(
//                    0.0f to Color.Black,  //MaterialTheme.colorScheme.background
//                    0.5f to Color.DarkGray,
//                    1.0f to Color.Black   //MaterialTheme.colorScheme.background
//                )
//            )
//        }

