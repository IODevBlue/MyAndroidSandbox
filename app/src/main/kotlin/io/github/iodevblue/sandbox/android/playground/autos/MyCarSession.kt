package io.github.iodevblue.sandbox.android.playground.autos

import android.content.Intent
import androidx.car.app.Session
import androidx.car.app.Screen
import androidx.car.app.CarContext

class MyCarSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return MyCarScreen(carContext)
    }
}
