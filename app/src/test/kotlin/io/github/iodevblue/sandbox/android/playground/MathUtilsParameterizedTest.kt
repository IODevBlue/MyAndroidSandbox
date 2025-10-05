package io.github.iodevblue.sandbox.android.playground

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MathUtilsParameterizedTest(
    private val inputA: Int,
    private val inputB: Int,
    private val expectedSum: Int
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = " {index}: {0} + {1} = {2}")
        fun data(): Collection<Array<Any>> = listOf(
            arrayOf(1, 1, 2),
            arrayOf(2, 3, 5),
            arrayOf(5, 5, 10),
            arrayOf(10, -2, 8),
        )
    }

    @Test
    fun testAddition() {
        assertEquals(expectedSum, inputA + inputB)
    }
}
