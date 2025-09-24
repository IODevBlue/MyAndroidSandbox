package io.github.iodevblue.sandbox.android.playground

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import io.github.iodevblue.sandbox.android.playground.ui.theme.MyAndroidSandBoxTheme
import io.github.iodevblue.sandbox.android.playground.ui.theme.mainBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GithubSample(repoLink: String) {
    val context = LocalContext.current

    // Scaffold provides a structure for your UI with a top app bar, content, etc.
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = stringResource(id = R.string.app_name))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = mainBlue, // Example color from AppBarOverlay
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        // Use a Column or Box to arrange your content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_github),
                contentDescription = "GitHub",
                modifier = Modifier
                    .padding(end = 25.dp, bottom = 50.dp)
                    .size(70.dp)
                    .background(mainBlue, CircleShape) // match your circle_bg drawable
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, repoLink.toUri())
                        context.startActivity(intent)
                    }
            )

        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GithubSamplePreview() {
    MyAndroidSandBoxTheme {
        GithubSample("Android Developer")
    }
}
