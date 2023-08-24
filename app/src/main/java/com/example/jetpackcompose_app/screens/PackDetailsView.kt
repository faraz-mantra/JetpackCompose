package com.example.jetpackcompose_app.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_app.R

@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = false)
@Composable
fun packDetails() {
    Box(modifier = Modifier.background(color = Color.White)) {
        Column(
            modifier = Modifier
                .padding(top = 26.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxWidth().fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            Card(elevation = CardDefaults.cardElevation(),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.padding(6.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.addons),
                        contentDescription = "", Modifier.height(80.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = "Custom Domain with SSL Security",
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "$3600.00/month",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 16.sp
                        )
                    }

                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "4 premium add-ons Ideal for small businesses that want to get started with online sales.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF4A4A4A),
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "It will expire post single use or on Aug 23, 2021 (whichever earlier) and can only be renewed post that.",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.07.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF4A4A4A),
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Add on is part of your plan",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 16.07.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF7ED321),
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Save more with a pack",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF4A4A4A),
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

//            LazyColumn(modifier = Modifier.height(200.dp),content = {
//                items(6){
//                    PacksCards()
//                }
//            })
            PacksCards()
            PacksCards()
            PacksCards()
            PacksCards()
            HorizontalPager(
                modifier = Modifier.padding(16.dp),
                state = rememberPagerState { banner().size },
                pageSpacing = 0.dp,
                userScrollEnabled = true,
                reverseLayout = false,
                contentPadding = PaddingValues(0.dp),
                beyondBoundsPageCount = 0,
                pageSize = PageSize.Fill,
                key = null,
                pageContent =  {
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
        }
    }
}

@Composable
fun PacksCards(){
        Box {
            Row ( verticalAlignment = Alignment.CenterVertically){

                Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                    Text(
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp),
                        text = "35% SAVING", style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight(700),
                            color = Color.White, background = Color(0xFF7ED321)
                        )
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Online Basic Pack",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF4A4A4A),
                        )
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "₹1,999/year for custom domain +3 more features",
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 12.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF4A4A4A),
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider(Modifier.fillMaxWidth())
                }

//                Text(
//                    modifier = Modifier.clickable { /* Handle click here */ },
//                    text = "View pack",
//                    style = TextStyle(
//                        fontSize = 11.sp,
//                        fontFamily = FontFamily.SansSerif,
//                        fontWeight = FontWeight(700),
//                        color = Color(0xFFFFB900),
//                        textAlign = TextAlign.Center,
//                    )
//                )


            }


        }


}