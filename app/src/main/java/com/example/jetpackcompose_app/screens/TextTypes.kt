package com.example.jetpackcompose_app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_app.R


@Composable
fun Greetings(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = Color.Blue,
        fontSize = 45.0.sp,
        maxLines = 1,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        style = TextStyle(textDecoration = TextDecoration.Underline),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFields1() {
    val state = remember { mutableStateOf("") }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        label = { Text(text = "Enter Name") }
    )
}

data class Category( val tilte: String,val img: Int,)

fun CategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category( tilte = "Addons", R.drawable.addons,))
    list.add(Category( tilte = "image", R.drawable.image_1,))
    list.add(Category( tilte = "Advnc pack", R.drawable.advance_pack,))
    list.add(Category( tilte = "Domain", R.drawable.ic_free_custom_domain,))

    return list
}

@Composable
fun CardsView(image: Int, tilte: String, subTitle:String = "String") {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .border(shape = RoundedCornerShape(4.dp), width = 1.dp, color = Color.Blue)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(image), contentDescription = "",
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            Column(
                Modifier
                    .padding(6.dp)
                    .weight(.8f)
            ) {
                Text(
                    text = tilte,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 26.sp
                )
                Text(
                    text = subTitle,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp
                )
            }
        }
    }
}

//@Preview(showBackground = false, showSystemUi = true)
@Composable
fun GreetingsPreview() {
    //CardsView()
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        CategoryList().map {
//            item -> CardsView(image = item.img, tilte = item.tilte, subTitle =item.subTitle )
//        }
//    }
    LazyColumn(content = {
        items(CategoryList()) { item ->
            CardsView(image = item.img, tilte = item.tilte)
        }
    })
}
