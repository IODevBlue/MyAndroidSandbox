package io.github.iodevblue.sandbox.android.playground

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import io.github.iodevblue.sandbox.android.playground.avd.AnimatedVectorExample
import io.github.iodevblue.sandbox.android.playground.avd.MorphingMenuIcon
import io.github.iodevblue.sandbox.android.playground.canvas.ParticleExplosionDemo
import io.github.iodevblue.sandbox.android.playground.rive.RiveAnimation
import io.github.iodevblue.sandbox.android.playground.spline.SplineWebView
import io.github.iodevblue.sandbox.android.playground.ui.theme.MyAndroidSandBoxTheme
import io.github.iodevblue.sandbox.android.playground.ui.theme.mainBlue
import io.github.iodevblue.sandbox.android.playground.webgl.WebGLActivity
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
        verticalArrangement =Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        WebGLView(
            Modifier
                .fillMaxSize(),

//                .fillMaxWidth()
//                .fillMaxHeight(.4f),
            assetPath = "webgl.html"
        )

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
