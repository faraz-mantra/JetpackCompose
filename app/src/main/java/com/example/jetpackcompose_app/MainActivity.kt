package com.example.jetpackcompose_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcompose_app.screens.ClickableTextWithAnimatedVisibility

import com.example.jetpackcompose_app.screens.ImageBorderAnimate
import com.example.jetpackcompose_app.screens.Marketplace
import com.example.jetpackcompose_app.screens.OtpField
import com.example.jetpackcompose_app.screens.OverlayWithBox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //TextFields()
         //   GreetingsPreview()
         //   Greetings(name = "Faraz")
          //  HorizontalViewPagerDemo()
          //  ClickableTextWithAnimatedVisibility()
          //  OtpField()
           // ImageBorderAnimate()
           // Marketplace()
            OverlayWithBox()
        }
    }
}

//@Composable
//fun ListViewTile() {
//
//    Row(Modifier.padding(16.dp)) {
//        Image(
//            painter = painterResource(id = R.drawable.addons),
//            contentDescription = "",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .drawBehind {
//                    drawCircle(
//                        color = Color.Magenta,
//                        style = Stroke(2.0f)
//                    )
//                }
//                .size(70.dp)
//                .clip(CircleShape)
//                .border(
//                    width = 2.dp, color = Color.Gray,
//                    CircleShape
//                )
//        )
//        Column(
//            Modifier
//                .padding(6.dp)
//                .scrollable(rememberScrollState(), Orientation.Vertical, enabled = true)
//        ) {
//            Text(
//                text = "MD Faraz!",
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.SansSerif,
//                fontSize = 26.sp
//            )
//            Text(
//                text = "Developer!",
//                fontFamily = FontFamily.SansSerif,
//                fontSize = 16.sp
//            )
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TextFields() {
//    val state = remember { mutableStateOf("") }
//    TextField(
//        value = state.value,
//        onValueChange = {
//            state.value = it
//        },
//        label = { Text(text = "Enter Name") }
//    )
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    JetPackCompose_AppTheme {
////        Greeting("JetPackCompose")
////        TextFields()
//        ListViewTile()
//    }
//}
