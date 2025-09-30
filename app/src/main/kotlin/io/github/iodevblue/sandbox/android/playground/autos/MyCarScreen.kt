package io.github.iodevblue.sandbox.android.playground.autos

import androidx.car.app.Screen
import androidx.car.app.CarContext
import androidx.car.app.model.Template
import androidx.car.app.model.MessageTemplate

class MyCarScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        return MessageTemplate.Builder("Hello from Android Auto!")
            .setTitle("Sandbox App")
            .build()
    }
}
