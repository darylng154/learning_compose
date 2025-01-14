package com.example.learning_compose.ui.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.w3c.dom.Text

@Composable
fun MySnackbar()
{
    // this version provides full control
    // - i.e. how long stays and where, etc
    // - default android component Scaffold
    Snackbar()
    {
        Text("Hello There")
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyScaffold()
{
    val snackBarHostState = remember {
        SnackbarHostState()
    }

    //  MutableState<String> object
//    val textFieldState = remember {
//        mutableStateOf("")
//    }

    // String object
    // - basically textFieldState.value
    var textFieldState by remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                label = {
                    // label of TextField (on top of text input)
                    Text("Name")
                },
                placeholder = {
                    // when clicked on TextField (Focus Mode) & Empty
                    Text("Please enter your name")
                },
                singleLine = true,
                value = textFieldState,
                onValueChange = {
                    textFieldState = it.toString()
            })

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // uses a coroutine
                    scope.launch {
                        snackBarHostState.showSnackbar("Hello $textFieldState")
                    }
                }
            )
            {
                Text("Greet Me")
            }
        }
    }
}