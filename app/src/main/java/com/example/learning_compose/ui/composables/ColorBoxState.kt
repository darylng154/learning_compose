package com.example.learning_compose.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

// uses internal state
@Composable
fun ColorBox(modifier: Modifier = Modifier)
{
    val colorState = remember {
        mutableStateOf(Color.Green)
    }

    Box(modifier = modifier
        .background(colorState.value)
        .clickable {
            colorState.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        })
}

// uses external state (state is outside the composable)
@Composable
fun ColorBox2(modifier: Modifier = Modifier, colorValue: Color, colorUpdate: (Color) -> Unit)
{
    Box(modifier = modifier
        .background(colorValue)
        .clickable {
            // using Lambda Function to update Color
            colorUpdate(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        })
}

// each box changes the other box's colors
@Composable
fun MultipleColorBox()
{
    val topColorState = remember {
        mutableStateOf(Color.Red)
    }

    val bottomColorState = remember {
        mutableStateOf(Color.Green)
    }

    Column(Modifier.fillMaxSize()) {
        ColorBox2(
            Modifier
                .weight(1f)
                .fillMaxSize(),
            topColorState.value
        )
        {
            bottomColorState.value = it
        }
//        Box(
//            modifier = Modifier
//                .background(topColorState.value)
//                .weight(1f)
//                .fillMaxSize()
//        )
        ColorBox2(
            modifier = Modifier
                .background(topColorState.value)
                .weight(1f)
                .fillMaxSize(),
            bottomColorState.value
        )
        {
            topColorState.value = it
        }
    }
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