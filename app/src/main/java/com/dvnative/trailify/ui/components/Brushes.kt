package com.dvnative.trailify.ui.components

import androidx.compose.ui.graphics.Brush
import com.dvnative.trailify.ui.tokens.BlueNight
import com.dvnative.trailify.ui.tokens.VioletNight

val bubbleBackgroundGradient = Brush.horizontalGradient(
     colorStops = arrayOf(
         0.0f to BlueNight,  //MaterialTheme.colorScheme.background
         0.25f to BlueNight,  //MaterialTheme.colorScheme.background
         0.5f to VioletNight,
         0.75f to BlueNight,//MaterialTheme.colorScheme.background
         1.0f to BlueNight   //MaterialTheme.colorScheme.background
     )
)

val backgroundGradient = Brush.horizontalGradient(
    colorStops = arrayOf(
        0.0f to BlueNight,  //MaterialTheme.colorScheme.background
        0.5f to VioletNight,
        1.0f to BlueNight   //MaterialTheme.colorScheme.background
    )
)