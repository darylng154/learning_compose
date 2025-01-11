package com.example.learning_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learning_compose.ui.theme.Learning_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnOfStyledText()
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

@Preview(name = "Image Card", showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ImageCardPreview()
{
    ProfileCard("User Profile")
}

@Preview(name = "Styling Text", showBackground = true)
@Composable
fun StylingTextPreview()
{
    ColumnOfStyledText()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
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
            text = "Hello $name!",
            modifier = modifier.offset()
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