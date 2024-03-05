package com.dvnative.trailify.ui.widgets

import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.launch

@Composable
fun WebViewDialogAt(url: String?, isOpen: MutableState<Boolean>, onUrlLoad: (String) -> Boolean = {false}){
    if (isOpen.value) {
        Dialog(
            onDismissRequest = { isOpen.value = false },
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
                decorFitsSystemWindows = true,
            ),
        ) {
            url?.let {
                WebViewAt(url = it, onUrlLoad)
            }
        }

    }
}

@Composable
fun WebViewAt(url: String, onUrlLoad: (String) -> Boolean = { false }) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    AndroidView(modifier = Modifier.verticalScroll(rememberScrollState()), factory = {
        WebView(context).apply {
            isVerticalScrollBarEnabled = true
            this.setLayerType(View.LAYER_TYPE_HARDWARE, null)
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    return onUrlLoad(request?.url.toString())
                }
            }
            webChromeClient = WebChromeClient()

        }
    }, update = {
        scope.launch {
            if (url == "") {
                it.removeAllViews()
                it.destroy()
            } else {
                it.loadUrl(url)
            }
        }
    })
}