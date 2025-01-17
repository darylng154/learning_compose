package com.example.learning_compose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.learning_compose.ui.composables.Greeting
import com.example.learning_compose.ui.theme.Learning_composeTheme

@Preview
@Composable
fun GreetingScreen()
{
    Learning_composeTheme {
        Greeting("User")
    }
}

@Preview
@Composable
fun GreetingScreenEmpty()
{
    Learning_composeTheme {
        Greeting("")
    }
}

@Preview
@Composable
fun GreetingScreenNull()
{
    Learning_composeTheme {
        Greeting(null)
    }
}

@Composable
fun GreetingScreen(name: String?)
{
    Learning_composeTheme {
        Greeting(name)
    }
}