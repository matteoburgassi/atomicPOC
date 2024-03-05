package com.dvnative.trailify.ui.components

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dvnative.trailify.ui.theme.playupFontFamily
import com.dvnative.trailify.ui.theme.trailifyFontFamily

// Set of Material typography styles to start with
val PlayupTypography = Typography(
    bodyMedium = TextStyle(
        fontFamily = playupFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ),
    //H1
    titleLarge = TextStyle(
        fontFamily = playupFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp
    ),
    //H1
    labelMedium = TextStyle(
        fontFamily = playupFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    ),
)
val TrailifyTypography = Typography(
    bodyMedium = TextStyle(
        fontFamily = trailifyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ),
    //H1
    titleLarge = TextStyle(
        fontFamily = trailifyFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp
    ),
    //H1
    labelMedium = TextStyle(
        fontFamily = trailifyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    ),
)