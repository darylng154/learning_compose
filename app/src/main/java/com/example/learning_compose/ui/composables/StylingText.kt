package com.example.learning_compose.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.learning_compose.R

@Composable
fun StylingText(text: AnnotatedString)
{
    val bungeeFont = FontFamily(Font(R.font.bungee_spice_regular))

    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFF101010)))
    {
        Text(
            /* buildAnnotatedString
               - lets you style each text differently
               - similar to StringBuilder
            */
            text = text,
            fontSize = 30.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontFamily = bungeeFont,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,    // unsupported by font
            textDecoration = TextDecoration.Underline
        )
    }
}

@Composable
fun AnnotatedText()
{
    val annotedStr = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Cyan,
                fontStyle = FontStyle.Normal
            )
        )
        {
            append("This Text Will Be ")
        }
        withStyle(
            style = SpanStyle(
                color = Color.Magenta,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.LineThrough
            )
        )
        {
            append("Styled Differently")
        }
    }
    StylingText(text = annotedStr)
}

@Composable
fun StylingText(text: String)
{
    val bungeeFont = FontFamily(Font(R.font.bungee_spice_regular))

    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFF101010)))
    {
        Text(
            /* buildAnnotatedString
               - lets you style each text differently
               - similar to StringBuilder
            */
            text = text,
            fontSize = 30.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontFamily = bungeeFont,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,    // unsupported by font
            textDecoration = TextDecoration.Underline
        )
    }
}

@Composable
fun ColumnOfStyledText()
{
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    )
    {

        StylingText("This Text Will Be Styled")
        AnnotatedText()
    }
}