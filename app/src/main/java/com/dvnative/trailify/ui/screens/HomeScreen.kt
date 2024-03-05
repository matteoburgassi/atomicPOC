package com.dvnative.trailify.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dvnative.trailify.ui.components.Title
import com.dvnative.trailify.ui.theme.AppTheme
import com.dvnative.trailify.ui.theme.extraColors
import com.dvnative.trailify.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    AppTheme {
        Scaffold {paddingValues ->
            Column(
                modifier = Modifier
                    .background(MaterialTheme.extraColors.backgroundGradient)
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Title(text = "You're successfully signed in")
            }
        }
    }
}
