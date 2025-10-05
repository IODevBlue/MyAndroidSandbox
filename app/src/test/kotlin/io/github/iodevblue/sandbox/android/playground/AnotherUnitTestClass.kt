package io.github.iodevblue.sandbox.android.playground

import junit.framework.TestCase.assertEquals
import org.junit.Test

class AnotherUnitTestClass {

    @Test
    fun testSomethingElse() {
        val anotherString = "Another String"
        assertEquals(anotherString.uppercase() == "ANOTHER STRING", true)

    }

    @Test
    fun testThisAgain() {
        val four = 2 + 2
        assert(four == 2.times(2))
    }
}