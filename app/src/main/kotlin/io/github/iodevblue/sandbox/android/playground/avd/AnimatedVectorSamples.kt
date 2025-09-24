package io.github.iodevblue.sandbox.android.playground.avd

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.iodevblue.sandbox.android.playground.R

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun AnimatedVectorExample() {
    var atEnd by remember { mutableStateOf(false) }

    val image = AnimatedImageVector.animatedVectorResource(R.drawable.avd_check)
    val painter = rememberAnimatedVectorPainter(image, atEnd)

    Button(onClick = { atEnd = !atEnd }) {
        Text("Play Animation")
    }

    Image(
        painter = painter,
        contentDescription = "Animated Checkmark"
    )
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
// TODO: Add this icon to parallax navigation drawer compose.
fun MorphingMenuIcon(onClick: () -> Unit = {}) {
    var toggled by remember { mutableStateOf(false) }

    val avd = AnimatedImageVector.animatedVectorResource(R.drawable.avd_menu_close)
    val painter = rememberAnimatedVectorPainter(avd, atEnd = toggled)

    Icon(
        painter = painter,
        contentDescription = "Menu/Close",
        modifier = Modifier
            .size(48.dp)
            .clickable {
                toggled = !toggled
                onClick()
            }
    )
}


