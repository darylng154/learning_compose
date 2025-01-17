package com.example.learning_compose.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learning_compose.ui.theme.Learning_composeTheme

@Composable
fun Greeting(name: String?, greetingTextModifier: Modifier? = Modifier) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Cyan),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceAround
//    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(top = 20.dp)
            .border(5.dp, Color.Red),
        verticalArrangement = Arrangement.SpaceEvenly,
//        horizontalAlignment = Alignment.Start
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = if(name != null && !name.equals("")) "Hello $name!" else "Hello!",
            modifier = greetingTextModifier ?: Modifier // modifier = if(modifier != null) modifier else Modifier
        )
        Text(text = "Test")
        Text(text = "Should Be on Bottom")

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth(0.5f)
                .fillMaxHeight(1f),
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(text = "Green Text")
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
