package com.example.learning_compose.ui.composables

import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.Duration

/*
*** Goal: Toast should only appear on first launch of app ***
*/

// Toast always appears after every counter update
// Note: clicking the button doesn't cause a recomposition
@Composable
fun WithoutSideEffect()
{
    var counter by remember {
        mutableStateOf(0)
    }

    val context = LocalContext.current

    Toast.makeText(context, "This is a Toast! Cheers.", Toast.LENGTH_SHORT).show()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "$counter"
        )
        Button(
            onClick = {
                counter++
            }
        )
        {
            Text("Update Counter")
        }
    }
}

@Composable
fun WithLaunchedEffect()
{
    var counter by remember {
        mutableStateOf(0)
    }

    val context = LocalContext.current

    // only runs it once during launch
    // TO DO: check to see if it launches when screen is navigated to
    LaunchedEffect(key1 = true) {
        Toast.makeText(context, "This is a Toast! Cheers.", Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "$counter"
        )
        Button(
            onClick = {
                counter++
            }
        )
        {
            Text("Update Counter")
        }
    }
}

@Composable
fun WithCounterChange()
{
    var counter by remember {
        mutableStateOf(0)
    }

    val context = LocalContext.current

//    key can be a state
//    - w/e state changes, it reruns the coroutine
    LaunchedEffect(key1 = counter) {
        Toast.makeText(context, "This is a Toast! Cheers #$counter", Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "$counter"
        )
        Button(
            onClick = {
                counter++
            }
        )
        {
            Text("Update Counter")
        }
    }
}

// Look at Snackbar.kt/MyScaffold() for rememberCoroutineScope() usage

