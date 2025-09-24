package io.github.iodevblue.sandbox.android.playground.webgl

import android.view.View
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.remember

@Composable
fun WebGLView(
    modifier: Modifier = Modifier,
    assetPath: String
) {
    val context = LocalContext.current
    val fragmentManager = (context as? AppCompatActivity)?.supportFragmentManager

    // Remember a generated ID so Compose doesn’t recreate one each recomposition
    val containerId = remember { View.generateViewId() }

    AndroidView(
        modifier = modifier,
        factory = { ctx ->
            FrameLayout(ctx).apply {
                id = containerId

                // Defer transaction until this view is attached
                post {
                    if (fragmentManager?.findFragmentById(id) == null) {
                        fragmentManager?.beginTransaction()
                            ?.replace(id, WebGLFragment.newInstance(assetPath))
                            ?.commitNowAllowingStateLoss()
                    }
                }
            }
        }
    )
}

