package com.dvnative.trailify.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dvnative.trailify.events.SplashLoginEvent
import com.dvnative.trailify.ui.screens.AppNotAvailable
import com.dvnative.trailify.ui.screens.HomeScreen
import com.dvnative.trailify.ui.screens.SplashScreen
import com.dvnative.trailify.viewmodel.MainViewModel

@Composable
fun NavigationComponent(navController: NavHostController, mainViewModel: MainViewModel, mainScreenUiState: SplashLoginEvent) {
    NavHost(
        navController = navController,
        startDestination = "splashlogin"
    ) {
        composable("unavailable") {
            AppNotAvailable()
        }
        composable("splashlogin",
            exitTransition = {
            fadeOut(animationSpec = tween(500, delayMillis = 0))
        }) {
            SplashScreen(
                viewModel = mainViewModel,
                mainScreenUIState = mainScreenUiState,
                onConfigurationError = { navController.navigate("unavailable") },
                onLoginSuccess = { navController.navigate("home") })
        }
        composable(route = "home",
            enterTransition = {
                fadeIn(animationSpec = tween(500, delayMillis = 0))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(500, delayMillis = 0))
            }

        ) {
            HomeScreen(mainViewModel)
        }
    }
}