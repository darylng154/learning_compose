package com.example.learning_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.learning_compose.ui.theme.Learning_composeTheme

import com.example.learning_compose.ui.composables.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnOfStyledText()
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