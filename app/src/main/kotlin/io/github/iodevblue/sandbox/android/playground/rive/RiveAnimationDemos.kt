package io.github.iodevblue.sandbox.android.playground.rive

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import app.rive.runtime.kotlin.RiveAnimationView
import app.rive.runtime.kotlin.core.Fit
import io.github.iodevblue.sandbox.android.playground.R

@Composable
fun RiveAnimation(@RawRes idRes: Int, modifier: Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            RiveAnimationView(context).apply {
                setRiveResource(
                    resId = idRes,
                    artboardName = "Artboard",       // Or whatever artboard name is in the .riv
                    stateMachineName = "State Machine 1", // 👈 the state machine name from the file
                    autoplay = true
                )
            }

        }
    )
}

@Composable
fun RiveTimerAnimation(modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            RiveAnimationView(context).apply {
                setRiveResource(
                    resId = R.raw.timer_with_data_binding,
                    artboardName = "Artboard",       // Or whatever artboard name is in the .riv
                    stateMachineName = "State Machine 1", // 👈 the state machine name from the file
                    autoplay = true,
                    fit = Fit.LAYOUT
                )
            }

        }
    )
}
