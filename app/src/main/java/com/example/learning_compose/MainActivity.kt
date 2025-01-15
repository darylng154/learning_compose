package com.example.learning_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.learning_compose.ui.theme.Learning_composeTheme

import com.example.learning_compose.ui.composables.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            WithLaunchedEffect()
            WithCounterChange()
        }
    }
}

@Preview(name = "Greeting",showBackground = true)
@Composable
fun GreetingPreview() {
    Learning_composeTheme {
        Greeting("User")
    }
}

@Preview(name = "Image Card", showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ImageCardPreview()
{
    ProfileCard("User Profile")
}

@Preview(name = "Styling Text", showBackground = true)
@Composable
fun StylingTextPreview()
{
    ColumnOfStyledText()
}

@Preview(name = "Color Box State", showBackground = true)
@Composable
fun ColorBoxPreview()
{
    ColorBox(
        Modifier.fillMaxSize()
    )
}

@Preview(name = "Multiple Color Box State", showBackground = true)
@Composable
fun MultipleColorBoxPreview()
{
    MultipleColorBox()
}

@Preview(name = "My Snackbar", showBackground = true)
@Composable
fun MySnackbarPreview()
{
    MySnackbar()
}

@Preview(name = "My Scaffold", showBackground = true)
@Composable
fun MyScaffoldPreview()
{
    MyScaffold()
}