package com.dvnative.trailify.ui.theme

import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp
import com.dvnative.trailify.ui.tokens.sizes

val playupShapes = Shapes()
    .also {
        it.sizes.labelPadding = 14.dp
        it.sizes.editTextOutlineBorder = 1.dp
        it.sizes.buttonOutlineBorder = 1.dp
        it.sizes.textFieldBorderRadius = 5.dp
        it.sizes.buttonsBorderRadius = 10.dp
        it.sizes.screenHorizontalPadding = 10.dp
        it.sizes.titleVerticalPadding = 20.dp
    }