package com.dvnative.trailify.ui.tokens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val Shapes.sizes: SizeTokens
    get() {
        return SizeTokens()
    }

class SizeTokens {
    var labelPadding = 14.dp
    var editTextOutlineBorder = 1.dp
    var buttonOutlineBorder = 1.dp
    var textFieldBorderRadius = 5.dp
    var buttonsBorderRadius = 5.dp
    var screenHorizontalPadding = 10.dp
    var titleVerticalPadding = 20.dp
}

