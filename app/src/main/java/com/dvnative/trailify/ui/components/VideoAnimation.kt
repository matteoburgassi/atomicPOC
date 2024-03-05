package com.dvnative.trailify.ui.components

import android.annotation.SuppressLint
import android.view.TextureView
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.OptIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player.REPEAT_MODE_OFF
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.effect.AlphaScale
import androidx.media3.exoplayer.ExoPlayer
import com.dvnative.trailify.R

@SuppressLint("OpaqueUnitKey")
@OptIn(UnstableApi::class) @Composable
fun VideoAnimation () {
    val context = LocalContext.current
    val uri = RawResourceDataSource.buildRawResourceUri(R.raw.animation_logo)
    val mediaItem = MediaItem.Builder()
        .setUri(uri)
        .build()
    val exoPlayer = remember(context, mediaItem) {
        ExoPlayer.Builder(context)
            .build()
            .also { exoPlayer ->
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.setVideoEffects(listOf(
                    AlphaScale(0.0f)
                ))
                exoPlayer.playWhenReady = true
                exoPlayer.repeatMode = REPEAT_MODE_OFF
                exoPlayer.prepare()
            }
    }

    DisposableEffect(
        key1 = AndroidView(factory = {
            TextureView(context).apply {
                isOpaque = false
                layoutParams =
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams
                            .MATCH_PARENT,
                        ViewGroup.LayoutParams
                            .MATCH_PARENT
                    )
                exoPlayer.setVideoTextureView(this)
            }
        })
    ) {
        onDispose { exoPlayer.release() }
    }
}