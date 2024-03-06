package com.dvnative.trailify.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import com.dvnative.trailify.storage.PLAYUP_THEME
import com.dvnative.trailify.storage.Prefs
import com.dvnative.trailify.storage.TRAILIFY_THEME
import com.dvnative.trailify.ui.components.PlayupTypography
import com.dvnative.trailify.ui.components.TrailifyTypography
import java.lang.NullPointerException

private val LocalColorScheme = staticCompositionLocalOf { TrailifyDesignSystem }

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme: DesignSystem
    val typography: Typography

    when(Prefs.getTheme(LocalContext.current)) {
        TRAILIFY_THEME -> {
            colorScheme = TrailifyDesignSystem
            typography = TrailifyTypography
        }
        PLAYUP_THEME -> {
            colorScheme = PlayupDesignSystem
            typography = PlayupTypography
        }
        else -> {
            throw NullPointerException("theme cannot be null")
        }
    }

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
            typography = typography,
            content = content
        )
    }
}

val MaterialTheme.extraValues: DesignSystem
    @Composable
    @ReadOnlyComposable
    get() = LocalColorScheme.current