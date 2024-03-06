package com.dvnative.trailify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.dvnative.trailify.navigation.NavigationComponent
import com.dvnative.trailify.ui.theme.AppTheme
import com.dvnative.trailify.ui.theme.extraValues
import com.dvnative.trailify.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainScreenUIState by viewModel.mainUiState.collectAsState()
            val isCountryOverridden by viewModel.debugOverriddenState.collectAsState()
            val navController = rememberNavController()

            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.background(MaterialTheme.extraValues.backgroundGradient),
                    color = Color.Transparent
                ) {
                    NavigationComponent(navController, viewModel, mainScreenUIState)
                }
            }
        }
    }
}
