package io.github.iodevblue.sandbox.android.playground.suites

import io.github.iodevblue.sandbox.android.playground.AnotherUnitTestClass
import io.github.iodevblue.sandbox.android.playground.ExampleUnitTest
import io.github.iodevblue.sandbox.android.playground.MathUtilsParameterizedTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AnotherUnitTestClass::class,
    ExampleUnitTest::class,
    MathUtilsParameterizedTest::class
)
class TestSuiteClass