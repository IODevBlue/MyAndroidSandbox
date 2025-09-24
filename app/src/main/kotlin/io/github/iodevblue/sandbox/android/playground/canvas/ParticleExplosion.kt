package io.github.iodevblue.sandbox.android.playground.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

data class Particle(
    val start: Offset,
    val angle: Float,
    val speed: Float,
    val color: Color,
    val lifetime: Int,
    val maxLifetime: Int
)

@Composable
fun ParticleExplosionDemo(
    modifier: Modifier
) {
    val particles = remember { mutableStateListOf<Particle>() }

    Canvas(
        modifier = modifier
            .background(Color.Black)
            .pointerInput(Unit) {
                detectTapGestures { tapOffset ->
                    // Dynamic spawn size depending on current load
                    val particlesPerTap = if (particles.size > 400) 40 else 80

                    repeat(particlesPerTap) {
                        val angle = Random.nextFloat() * 360f
                        val speed = Random.nextFloat() * 6f + 2f
                        val color = Color(
                            red = Random.nextFloat(),
                            green = Random.nextFloat(),
                            blue = Random.nextFloat(),
                            alpha = 1f
                        )
                        val maxLifetime = Random.nextInt(20, 40) // shorter lifetime
                        particles.add(
                            Particle(
                                start = tapOffset,
                                angle = angle,
                                speed = speed,
                                color = color,
                                lifetime = maxLifetime,
                                maxLifetime = maxLifetime
                            )
                        )
                    }

                    // Cap the total particles
                    val maxParticles = 200
                    if (particles.size > maxParticles) {
                        repeat(particles.size - maxParticles) {
                            particles.removeAt(0) // drop oldest
                        }
                    }
                }
            }
    ) {
        val iterator = particles.listIterator()
        while (iterator.hasNext()) {
            val p = iterator.next()

            val progress = 1f - (p.lifetime / p.maxLifetime.toFloat())
            val distance = p.speed * progress * 100f
            val dx = cos(Math.toRadians(p.angle.toDouble())).toFloat() * distance
            val dy = sin(Math.toRadians(p.angle.toDouble())).toFloat() * distance

            val alpha = (p.lifetime / p.maxLifetime.toFloat()).coerceIn(0f, 1f)

            drawCircle(
                color = p.color.copy(alpha = alpha),
                radius = 5f,
                center = Offset(p.start.x + dx, p.start.y + dy)
            )

            if (p.lifetime <= 1) {
                iterator.remove()
            } else {
                iterator.set(p.copy(lifetime = p.lifetime - 1))
            }
        }
    }
}
