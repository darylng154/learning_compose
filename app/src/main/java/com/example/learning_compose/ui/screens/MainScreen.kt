package com.example.learning_compose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.w3c.dom.Text

@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        TextField(
            value = text,
            label = { Text("User Name")},
            onValueChange =
            {
                text = it.toString()
            }
        )
        Button(
            onClick = {
//                navController.navigate(Screen.GreetingScreen.route)
                navController.navigate(Screen.GreetingScreen.routeWithArgs(text))
            }
        ){
            Text("Go to ${Screen.MainScreen.route}")
        }
    }
}

@Preview(name = "Main Screen", showBackground = true)
@Composable
fun MainScreenPreview()
{
    val navController = rememberNavController()

    MainScreen(navController = navController)
}
