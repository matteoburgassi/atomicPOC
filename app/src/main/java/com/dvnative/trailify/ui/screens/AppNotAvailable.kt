package com.dvnative.trailify.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dvnative.trailify.R
import com.dvnative.trailify.ui.components.Body
import com.dvnative.trailify.ui.components.Title
import com.dvnative.trailify.ui.theme.AppTheme

@Composable
fun AppNotAvailable() {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Title(text = "App Not Available")
            Body(text = "Playup is not available in your country or region.", modifier = Modifier.fillMaxWidth(0.5f), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            Icon(imageVector = ImageVector.vectorResource(R.drawable.localization_pin_background), contentDescription = "pin", tint = Color.Unspecified)

        }
    }
}

@Preview
@Composable
fun AppNotAvailablePreview() {
    AppNotAvailable()
}