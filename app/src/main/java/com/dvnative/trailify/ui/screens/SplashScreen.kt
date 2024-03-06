package com.dvnative.trailify.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dvnative.trailify.R
import com.dvnative.trailify.events.SplashLoginEvent
import com.dvnative.trailify.events.SplashLoginEvent.ConfigurationError
import com.dvnative.trailify.events.SplashLoginEvent.ConfigurationReceived
import com.dvnative.trailify.events.SplashLoginEvent.CredentialsNotFound
import com.dvnative.trailify.events.SplashLoginEvent.LoginError
import com.dvnative.trailify.events.SplashLoginEvent.LoginSuccess
import com.dvnative.trailify.events.SplashLoginEvent.StartLoading
import com.dvnative.trailify.events.SplashLoginEvent.StartLoadingCredentials
import com.dvnative.trailify.events.SplashLoginEvent.WaitingForConfiguration
import com.dvnative.trailify.ui.components.LinksView
import com.dvnative.trailify.ui.components.Loader
import com.dvnative.trailify.ui.components.VideoAnimation
import com.dvnative.trailify.ui.theme.AppTheme
import com.dvnative.trailify.ui.theme.extraValues
import com.dvnative.trailify.ui.widgets.Login
import com.dvnative.trailify.ui.widgets.WebViewDialogAt
import com.dvnative.trailify.viewmodel.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    viewModel: MainViewModel,
    mainScreenUIState: SplashLoginEvent,
    onLoginSuccess: () -> Unit,
    onConfigurationError: () -> Unit,
    ) {
    val context = LocalContext.current
    val scaleAnimation = remember { Animatable(0f) }
    val moveAnimation = remember { Animatable(initialValue = 0.0f) }
    val url by remember {
        mutableStateOf("https://www.wikipedia.com")
    }
    val openWebview = remember {
        mutableStateOf(false)
    }
    WebViewDialogAt(url = url, isOpen = openWebview)
    LaunchedEffect("animationKey") {
        launch {
            scaleAnimation.animateTo(2.5f, tween(1200))
            delay(3000)
            viewModel.updateConfiguration()
        }
    }

    when(mainScreenUIState) {
        ConfigurationReceived -> {
            LaunchedEffect("loadingCredentials") {
                launch{
                    viewModel.loadUserContext(context)
                }
            }
        }
        else -> {}
    }

    AppTheme {
        Box(modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(modifier = Modifier
                .fillMaxSize(1f)
                .scale(scaleAnimation.value * 1.4f)
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(MaterialTheme.extraValues.splashContainer)
            )
            Box(modifier = Modifier
                .fillMaxSize(1f)
                .scale(scaleAnimation.value * 1.15f)
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(MaterialTheme.extraValues.splashPrimary)
            )
            Box(modifier = Modifier
                .fillMaxSize(1f)
                .scale(scaleAnimation.value)
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(MaterialTheme.extraValues.backgroundGradientVariant)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ){
                Row (modifier = Modifier
                    .fillMaxHeight(0.4f),
                    verticalAlignment = Alignment.CenterVertically){
                    Box(modifier = Modifier.fillMaxHeight(0.2f).fillMaxWidth(), contentAlignment = Alignment.Center){
                        if (MaterialTheme.extraValues.splashVideo) {
                            VideoAnimation()
                        } else {
                            Image(painter = painterResource(id = R.drawable.trailify_icon_logo), contentDescription = "iconLogo", modifier = Modifier.fillMaxSize())
                            Image(painter = painterResource(id = R.drawable.trailify_logo), contentDescription = "iconLogo", modifier = Modifier.fillMaxSize(0.4f))
                        }

                    }
                }
                Spacer(modifier = Modifier.fillMaxHeight(moveAnimation.value))
            }
            Crossfade(targetState = mainScreenUIState,
                label = "splash crossfade",
                animationSpec = tween(1000, easing = FastOutSlowInEasing)
            ) { state ->
                when (state) {
                    WaitingForConfiguration,
                    StartLoadingCredentials,
                    StartLoading, -> {
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Spacer(Modifier.fillMaxHeight(0.3f))
                            Row(Modifier.fillMaxHeight()) {
                                Loader()
                            }
                        }
                    }
                    ConfigurationError -> {
                        onConfigurationError()
                    }
                    CredentialsNotFound -> {
                        LaunchedEffect("moveUpAnimation") {
                            launch {
                                moveAnimation.animateTo(1f, tween(1000))
                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .imePadding()
                        ) {
                            Spacer(Modifier.fillMaxHeight(0.3f))
                            Login(viewModel = viewModel)
                            LinksView(openWebview = openWebview)
                        }
                    }
                    LoginSuccess -> {
                        onLoginSuccess()
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Spacer(Modifier.fillMaxHeight(0.3f))
                            Row(Modifier.fillMaxHeight()) {
                                Loader()
                            }
                        }
                    }
                    LoginError -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .imePadding()
                        ) {
                            Spacer(Modifier.fillMaxHeight(0.3f))
                            Login(viewModel = viewModel)
                            LinksView(openWebview = openWebview)
                        }
                    }
                    else -> {}
                }
            }

        }
    }
}

@Composable
@Preview
fun splashPreview() {
    splashPreview()
}