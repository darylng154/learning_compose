package com.example.learning_compose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learning_compose.R

@Composable
fun ImageCard(painter: Painter, contentDescription: String, title: String, modifier: Modifier = Modifier)
{
    Card (
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp)
    ){
        Box()
        {
            // widget order: top is bottom of stack
            // (top is the most bottom layer of the UI, everything below stacks onto of each other)
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 180f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            )
            {
                Text(
                    text = title,
                    // fontSize sp scales w/ user's text size preference while dp doesn't
                    fontSize = 16.sp,
                    style = TextStyle(color = Color.White)
                )
            }
        }
    }
}

@Composable
fun ProfileCard(description: String)
{
    val painter = painterResource(id = R.drawable.user)
    Box(modifier = Modifier.padding(16.dp))
    {
        ImageCard(
            painter = painter,
            contentDescription = description, title = description,
            modifier = Modifier
                .height(with(LocalDensity.current) { 360.toDp() })
                .width(with(LocalDensity.current) { 407.toDp() })
        )
    }
}