package com.dvnative.trailify.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import com.dvnative.trailify.ui.components.TrailifyTypography

private val LocalColorScheme = staticCompositionLocalOf { TrailifyColorScheme }

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {


    val colorScheme = TrailifyColorScheme
    val shapes: Shapes = playupShapes
    val typogrphy: Typography = TrailifyTypography

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb() //to be added in theme
        }
    }
    CompositionLocalProvider(LocalColorScheme provides colorScheme) {
        MaterialTheme(
            colorScheme = colorScheme.material,
            shapes = shapes,
            typography = typogrphy,
            content = content
        )
    }
}

val MaterialTheme.extraColors: DesignSystemColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColorScheme.current