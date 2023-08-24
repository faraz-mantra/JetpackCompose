@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.jetpackcompose_app.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose_app.R


@Composable
//AnimatedVisibility and hide feature
fun ClickableTextWithAnimatedVisibility() {
    var visible by remember { mutableStateOf(true) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AnimatedVisibility(
            visible = visible,
//            enter = fadeIn(animationSpec = tween(400, easing = LinearOutSlowInEasing)),
//            exit = fadeOut(animationSpec = tween(400, easing = LinearOutSlowInEasing))
        ) {
//            ClickableText(
//                text = buildAnnotatedString {
//                    // Normal text outside the clickable span.
//                    append("This is a ")
//
//                    // Create a clickable span in the text.
//                    pushStringAnnotation(
//                        tag = "Clickable",
//                        annotation = "Clickable text clicked!"
//                    )
//                    withStyle(
//                        style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)
//                    ) {
//                        append("clickable text")
//                    }
//                    pop()
//
//                    // Normal text outside the clickable span.
//                    append(" inside a ClickableText example.")
//                },
//                onClick = {
//                    // Toggle visibility when the clickable text is clicked.
//                    visible = !visible
//                }
//            )
            Text(
                text = "This is a description text. Click to hide.",
                style = TextStyle(
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier
                    .clickable { visible = !visible }
            )
        }

        // This button will make the ClickableText visible again.
        Button(onClick = { visible = true }) {
            Text("Show Clickable Text")
        }
    }
}


//ExpandingText feature.
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExpandingText() {
    var expanded by remember {
        mutableStateOf(false)
    }
    Text(
        "To prepare your app for release, you need to configure, build, and test a release version of your app. The configuration tasks involve basic code cleanup and code modification tasks that help optimize your app. The build process is similar to the debug build process and can be done using JDK and Android SDK tools.\n" +
                "\n" +
                "Testing tasks serve as a final check, helping ensure that your app performs as expected under real-world conditions. Firebase offers a large set of both physical and virtual test devices through Firebase Test Lab that you can use to improve your app quality.",
        modifier = Modifier
            .animateContentSize()
            .clickable {
                expanded = !expanded
            },
        maxLines = if (!expanded) 2 else 10
    )

}

@Preview(showSystemUi = true)
@Composable
fun ImageBorderAnimate() {
    val infiniteTransition = rememberInfiniteTransition()
    val rotationAnimation =infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing)), label = ""
    )
    val rainbowColors = listOf(
        Color(0xFFFF0000),
        Color(0xFFFF7F00),
        Color(0xFFFFFF00),
        Color(0xFF00FF00),
        Color(0xFF0000FF),
        Color(0xFF4B0082),
        Color(0xFF9400D3)
    )
    Image(
        modifier = Modifier
            .drawBehind {
                rotate(rotationAnimation.value) {
                    drawCircle(
                        brush = Brush.verticalGradient(
                            colors = rainbowColors
                        ),
                        style = Stroke(width = 6f)
                    )
                }
            }
            .padding(2.dp)
            .clip(CircleShape),
        painter = painterResource(id = R.drawable.addons),
        contentDescription = "",
        contentScale = ContentScale.Inside
    )
}






