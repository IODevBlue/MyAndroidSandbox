package io.github.iodevblue.sandbox.android.playground.spline

import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun SplineWebView(url: String, modifier: Modifier) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true // Enable DOM storage
                settings.loadsImagesAutomatically = true
                settings.useWideViewPort = true
                settings.loadWithOverviewMode = true
                settings.allowFileAccess = true
                settings.allowContentAccess = true

                // Optional: debug webview if needed
                WebView.setWebContentsDebuggingEnabled(true)

                // Ensure all navigation stays inside the WebView
                webViewClient = android.webkit.WebViewClient()

                loadUrl(url)
            }
        },
        modifier = modifier
    )
}
