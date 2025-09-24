package io.github.iodevblue.sandbox.android.playground.webgl

import android.annotation.SuppressLint
import android.content.res.loader.AssetsProvider
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class WebGLActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this).apply {
            settings.javaScriptEnabled = true
            settings.allowUniversalAccessFromFileURLs = true
            webChromeClient = object : WebChromeClient() {
                override fun onConsoleMessage(consoleMessage: android.webkit.ConsoleMessage): Boolean {
                    android.util.Log.d("WebViewConsole", consoleMessage.message())
                    return true
                }
            }
        }

        setContentView(webView)
        webView.loadUrl("file:///android_asset/webgl.html")
    }
}
