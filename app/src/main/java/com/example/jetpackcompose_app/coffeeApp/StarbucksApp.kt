package com.example.jetpackcompose_app.coffeeApp

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_app.R
import com.example.jetpackcompose_app.screens.CategoryList
import com.example.jetpackcompose_app.screens.banner
import com.example.jetpackcompose_app.ui.theme.DarkOrange
import com.example.jetpackcompose_app.ui.theme.GrayColor
import com.example.jetpackcompose_app.ui.theme.LightGray_1
import com.example.jetpackcompose_app.ui.theme.LineColor
import com.example.jetpackcompose_app.ui.theme.Purple80
import com.example.jetpackcompose_app.ui.theme.teal_700
import com.nameisjayant.chatappyt.starbucks.navigation.data.Menu
import com.nameisjayant.chatappyt.starbucks.navigation.data.menuList
import com.nameisjayant.projects.furniture.data.Rooms
import com.nameisjayant.projects.furniture.data.categoryList
import com.nameisjayant.projects.furniture.data.roomList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        LazyColumn(content = {
            item {
                Header()
                Spacer(modifier = Modifier.height(26.dp))
                WelcomeText()
                Spacer(modifier = Modifier.height(26.dp))
                Search()
                Spacer(modifier = Modifier.height(16.dp))
                CoffeeCategories()
                CommonTitle("Popular")
                AllCoffees()
                OffersBanners()
            }
        })
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OffersBanners() {
    val pagerState = rememberPagerState { banner().size }
    HorizontalPager(
        modifier = Modifier.padding(16.dp),
        state = pagerState,
        pageSpacing = 0.dp,
        userScrollEnabled = true,
        reverseLayout = false,
        contentPadding = PaddingValues(0.dp),
        beyondBoundsPageCount = 0,
        pageSize = PageSize.Fill,
        key = null,
        pageContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = banner()[it]),
                    contentDescription = ""
                )
            }
        }

    )
    LaunchedEffect(key1 = pagerState.currentPage) {
        launch {
            delay(3000)
            with(pagerState) {
                val target = if (currentPage < pageCount - 1) currentPage + 1 else 0

                animateScrollToPage(
                    page = target,
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = FastOutSlowInEasing
                    )
                )
            }
        }
    }

}

@Composable
fun Header() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
    ) {
        Box(
            modifier = Modifier
                .size(46.dp)
                .background(color = GrayColor, shape = CircleShape)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "",
                    tint = teal_700
                )

            }
        }
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")

        Box(
            modifier = Modifier
                .size(46.dp)
                .background(color = GrayColor, shape = CircleShape)
        ) {
            Icon(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(id = R.drawable.bag),
                contentDescription = "",
                tint = teal_700,
            )
        }
    }
}

@Composable
fun WelcomeText() {
    Text(
        text = "Our way of loving \n you back",
        style = TextStyle(
            fontSize = 26.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium
        )
    )
}

@Composable
fun Search() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(color = LineColor, shape = CircleShape)
    ) {
        val state = remember { mutableStateOf("") }
        TextField(modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(26.5.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = teal_700
            ),
            value = state.value,
            onValueChange = {
                state.value = it
            },
            label = { Text(text = "Search") },
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.search), contentDescription = "")
            },
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .size(53.dp)
                        .background(color = teal_700, shape = CircleShape)
                ) {
                    Icon(
                        modifier = Modifier.align(Alignment.Center),
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = ""
                    )
                }
            })
    }
}

@Composable
fun CoffeeCategories() {
    LazyRow(content = {
        items(menuList) {
            CategoriesCardView(it)
        }
    })
}

@Composable
fun CategoriesCardView(menu: Menu) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .background(color = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(26.dp)
                )
                .padding(10.dp)
        ) {
            Text("${menu.title}")
        }
    }
}

@Composable
fun CommonTitle(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.clickable(enabled = true, onClick = {}),
            text = "${title}",
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )
        TextButton(onClick = { }) {
            Text(text = "See All", fontSize = 16.sp, color = teal_700)
            Spacer(modifier = Modifier.width(3.dp))
            Icon(
                imageVector = Icons.Default.ArrowForward,
                tint = teal_700,
                modifier = Modifier.size(20.dp),
                contentDescription = ""
            )
        }
    }
}

@Composable
fun AllCoffees() {
    LazyRow(modifier = Modifier.fillMaxWidth(), content = {
        items(count = 5) {
            Column {
                Card(
                    modifier = Modifier
                        .width(220.dp)
                        .wrapContentHeight()
                        .background(color = Color.Transparent)
                        .padding(end = 10.dp)
                ) {
                    Column {
                        Image(
                            modifier = Modifier
                                .align(alignment = CenterHorizontally)
                                .padding(top = 16.dp)
                                .size(180.dp),
                            painter = painterResource(id = R.drawable.cappucino),
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Chocolate cappucino", Modifier.padding(12.dp),
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black
                            )
                        )
                        Text(
                            text = "$20.00", Modifier.padding(12.dp),
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = teal_700
                            )
                        )
                    }
                }
            }
        }
    })
}

