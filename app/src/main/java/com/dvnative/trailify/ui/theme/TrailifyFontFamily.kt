package com.dvnative.trailify.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.dvnative.trailify.R

val trailifyFontFamily = FontFamily(
    Font(R.font.segoe_ui_bold, FontWeight.Bold),
    Font(R.font.segoe_ui, FontWeight.Normal),
    Font(R.font.segoe_ui_italic, FontWeight.Normal, style = FontStyle.Italic),
)