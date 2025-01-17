package com.example.learning_compose.ui.navagation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.learning_compose.ui.composables.Greeting
import com.example.learning_compose.ui.screens.GreetingScreen
import com.example.learning_compose.ui.screens.MainScreen
import com.example.learning_compose.ui.screens.Screen


// ToDo: Updated Navigation Implementation
// Old Way to Do Navigation
@Composable
fun Navagation()
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route)
    {
        composable(
            route = Screen.MainScreen.route
        )
        {
            MainScreen(navController = navController)
        }
        composable(
            // ex of multiple arguments
//            route = Screen.GreetingScreen.route + "/{name1}/{name2}/.../{nameN}",
            route = Screen.GreetingScreen.route + "/{name}",
//            route = Screen.GreetingScreen.route + "?name = {name}",     // for optional arguments
            arguments = listOf(
                navArgument("name")     // name of argument
                {
                    // builder block to give argument some constraints
                    type = NavType.StringType
                    defaultValue = "User"
                    nullable = true
                }
            )
        )
        {
            // takes the name argument and uses it in the Screen
            entry ->
                GreetingScreen(name = entry.arguments?.getString("name"))
        }
    }
}