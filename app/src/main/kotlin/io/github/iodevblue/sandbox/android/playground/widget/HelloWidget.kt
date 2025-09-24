package io.github.iodevblue.sandbox.android.playground.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.ActionParameters
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.updateAll
import androidx.glance.color.ColorProvider
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import kotlinx.coroutines.flow.map
import kotlin.random.Random

// 🔹 DataStore setup

// TODO: Next up is dynamic content according to widget size.
val Context.helloWidgetStore by preferencesDataStore("HelloWidget")
val Name = stringPreferencesKey("name")
var helloWidgetID: GlanceId? = null

class HelloWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val store = context.helloWidgetStore

        provideContent {
            // Observe DataStore continuously
            val nameFlow = store.data.map { it[Name] ?: "World" }
            val currentName by nameFlow.collectAsState(initial = "World")

            WidgetContent(currentName, context)
        }
    }


    @Composable
    private fun WidgetContent(initialName: String, context: Context) {
        val scope = rememberCoroutineScope()

        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.Vertical.CenterVertically,
            horizontalAlignment = Alignment.Horizontal.CenterHorizontally
        ) {
            Text(
                text = "Hello $initialName 👋",
                style = TextStyle(
                    color = ColorProvider(day = Color.Black, night = Color.White),
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(GlanceModifier.height(8.dp))
            Text(
                text = "Tap to change name",
                modifier = GlanceModifier.clickable(actionRunCallback<ChangeNameAction>())
            )
        }
    }
}

// 🔹 Receiver to register widget
class HelloWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = HelloWidget()
}

val randomNames = listOf(
    "Aiden", "Sophia", "Mateo", "Leila", "Kai",
    "Zarah", "Elias", "Hana", "Luca", "Naomi",
    "Kofi", "Aria", "Omar", "Ayla", "Darius",
    "Noelle", "Soren", "Priya", "Hugo", "Anika",
    "Malik", "Yara", "Rafael", "Selene", "Idris",
    "Amara", "Koji", "Fatima", "Ezra", "Imani",
    "Leo", "Carmen", "Ashwin", "Mira", "Thiago",
    "Zainab", "Dante", "Keira", "Jalen", "Amina",
    "Rowan", "Mei", "Cyrus", "Elif", "Tariq",
    "Lila", "Xavier", "Nia", "Orlando", "Safiya"
)


class ChangeNameAction : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        // Pick a random name
        val newName = randomNames.random(Random.Default)

        // Save to datastore
        context.helloWidgetStore.edit { prefs ->
            prefs[Name] = newName
        }
        val wig = HelloWidget()

//        helloWidgetID?.let {
//            wig.update(context, it)
//            Toast.makeText(context, "Widget Updated with name: $newName", Toast.LENGTH_SHORT).show()
//        } ?: run {
            wig.updateAll(context)
//        }
    }
}
