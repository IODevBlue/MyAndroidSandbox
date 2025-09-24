package io.github.iodevblue.sandbox.android.playground.canvas

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun MovingCircleDemo() {
    val circleRadius = 40f
    val circleColor = Color(0xFF4285F4)

    // Animation state
    val xOffset = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    // Launch the animation once
    LaunchedEffect(Unit) {
        xOffset.animateTo(
            targetValue = 800f, // animate 800px to the right
            animationSpec = infiniteRepeatable(
                animation = tween(2000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        drawCircle(
            color = circleColor,
            radius = circleRadius,
            center = Offset(xOffset.value, size.height / 2)
        )
    }
}

