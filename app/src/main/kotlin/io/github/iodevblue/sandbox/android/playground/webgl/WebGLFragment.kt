package io.github.iodevblue.sandbox.android.playground.webgl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class WebGLFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return WebView(requireContext()).apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.allowFileAccess = true
            settings.allowContentAccess = true
            settings.allowUniversalAccessFromFileURLs = true
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
            setLayerType(View.LAYER_TYPE_HARDWARE, null)

            val assetPath = requireArguments().getString(ARG_ASSET) ?: ""
            loadUrl("file:///android_asset/$assetPath")
        }
    }

    companion object {
        private const val ARG_ASSET = "assetPath"
        fun newInstance(assetPath: String) = WebGLFragment().apply {
            arguments = bundleOf(ARG_ASSET to assetPath)
        }
    }
}
