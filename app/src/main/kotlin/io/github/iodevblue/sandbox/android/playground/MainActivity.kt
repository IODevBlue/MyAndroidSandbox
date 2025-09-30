package io.github.iodevblue.sandbox.android.playground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.iodevblue.sandbox.android.playground.ui.theme.MyAndroidSandBoxTheme
import io.github.iodevblue.sandbox.android.playground.views.AppNavHost
import io.github.iodevblue.sandbox.android.playground.webgl.WebGLView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAndroidSandBoxTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .verticalScroll(rememberScrollState()) // 👈 makes it scrollable
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppNavHost()

//        WebGLView(
//            Modifier.fillMaxSize(),
//            assetPath = "webgl.html"
//        )

//        Spacer(modifier = Modifier.height(16.dp))
//        ParticleExplosionDemo(
//            Modifier.fillMaxWidth()
//                .fillMaxHeight(.2f)
//        )
//
//        AnimatedVectorExample()
//        MorphingMenuIcon()
//
//        val context = LocalContext.current
//        Text(
//            text = "Open WebGL Demo",
//            color = Color.White,
//            modifier = Modifier
//                .background(Color.Blue, CircleShape)
//                .padding(16.dp)
//                .clickable {
//                    context.startActivity(Intent(context, WebGLActivity::class.java))
//                }
//        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MainScreenPreview() {
   MainScreen()
}
