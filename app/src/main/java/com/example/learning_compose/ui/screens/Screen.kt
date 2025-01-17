package com.example.learning_compose.ui.screens

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object GreetingScreen: Screen("greeting_screen")

    // does not support nullable pathways
    fun routeWithArgs(vararg args: String): String
    {
        return buildString {
            append(route)

            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}