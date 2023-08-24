package com.example.jetpackcompose_app.screens

import android.annotation.SuppressLint
import android.icu.number.Scale
import android.view.Gravity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_app.R
import com.nameisjayant.projects.furniture.data.PopularProducts
import com.nameisjayant.projects.furniture.data.Rooms
import com.nameisjayant.projects.furniture.data.roomList

//data class images(var pic:Int )

fun promoBanners(): MutableList<Int> {

    val promoList = mutableListOf<Int>()

    promoList.add(R.drawable.partner_placeholder)
    promoList.add(R.drawable.partner_placeholder)

    return promoList
}

fun banner(): MutableList<Int> {
    var banners = mutableListOf<Int>()

    banners.add(R.drawable.holi_banner)
    banners.add(R.drawable.partner_placeholder)
    banners.add(R.drawable.banner)

    return banners
}

fun packs(): MutableList<Int> {
    var list = mutableListOf<Int>()

    list.add(R.drawable.pack)
    list.add(R.drawable.pack)

    return list
}

fun addons(): MutableList<Int> {
    val list2 = mutableListOf<Int>()

    list2.add(R.drawable.addon_banner)
    list2.add(R.drawable.addon_banner)
    list2.add(R.drawable.addon_banner)
    return list2
}

data class Videos(

    var pic: Int, var texts: String
)

fun videosData(): MutableList<Videos> {

    val list3 = mutableListOf<Videos>()
    list3.add(
        Videos(
            R.drawable.video_banner,
            texts = "Watch how a chatbot makes your site 2x interactive"
        )
    )
    list3.add(
        Videos(
            R.drawable.video_banner,
            texts = "Watch how a chatbot makes your site 2x interactive"
        )
    )
    list3.add(
        Videos(
            R.drawable.video_banner,
            texts = "Watch how a chatbot makes your site 2x interactive"
        )
    )
    list3.add(
        Videos(
            R.drawable.video_banner,
            texts = "Watch how a chatbot makes your site 2x interactive"
        )
    )
    return list3
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Preview(showSystemUi = false)
@Composable
fun Marketplace() {

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

        Box(
            modifier = Modifier
                .wrapContentHeight()
                .background(color = Color(0xFF5E5E5E))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White,
                                Color(0xFFEDEDED)
                            )
                        ),
                        shape = RoundedCornerShape(bottomEnd = 26.dp, bottomStart = 26.dp)
                    )
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = ""
                        )
                        Image(
                            modifier = Modifier.size(28.dp),
                            painter = painterResource(id = R.drawable.ic_marketplace_cart_black),
                            contentDescription = ""
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    Box( modifier = Modifier.fillMaxWidth()) {
                        Image(
                            modifier = Modifier
                                .size(60.dp)
                                .align(Alignment.Center),
                            painter = painterResource(id = R.drawable.ic_boost_logo_arrow),
                            contentDescription = ""
                        )

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Welcome to Boost 360 ", fontSize = 13.sp)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Feature Marketplace", fontSize = 24.sp)
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "My current plan",
                            fontSize = 14.sp,
                            color = Color(0xFFFFB900),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    banner().size
                    HorizontalPager(
                        modifier = Modifier.padding(16.dp),
                        state = rememberPagerState { banner().size },
                        pageSpacing = 0.dp,
//                        horizontalAlignment = horizontalAlignment,
                        userScrollEnabled = true,
                        reverseLayout = false,
                        contentPadding = PaddingValues(0.dp),
                        beyondBoundsPageCount = 0,
                        pageSize = PageSize.Fill,
                     //   flingBehavior = PagerDefaults.flingBehavior(state = ),
                        key = null,
//                        pageNestedScrollConnection = remember(state) {
//                            PagerDefaults.pageNestedScrollConnection(state, Orientation.Horizontal)
//                        },
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

        Box(modifier = Modifier.background(Color(0xFFFFB900))) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(shape = RoundedCornerShape(bottomStart = 26.dp, bottomEnd = 26.dp))
                    .background(color = Color(0xFF5E5E5E))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Save upto 60% with features pack",
                        fontSize = 18.sp,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(8.dp))

//                    HorizontalPager(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .wrapContentHeight(),
//                        pageCount = packs().size
//                    ) {
//
//                        var pack = packs()
//
//                        Image(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .wrapContentHeight()
//                                .padding(bottom = 12.dp),
//                            contentScale = ContentScale.FillWidth,
//                            painter = painterResource(id = pack[it]),
//                            contentDescription = ""
//                        )
//
//                    }

                }

            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 12.dp)
                .clip(shape = RoundedCornerShape(bottomEnd = 26.dp, bottomStart = 26.dp))
                .background(Color(0xFFFFB900))
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            )
            {
                Text(
                    text = "Top manufacturing features",
                    fontSize = 18.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                val a = addons()
                val addonsList: MutableList<Int> = addons()
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    state = rememberLazyListState(),
                    content = {
                        items(addonsList) { item ->
                            Image(
                                modifier = Modifier
                                    .size(width = 123.dp, height = 192.dp)
                                    .wrapContentHeight()
                                    .padding(bottom = 5.dp),
                                contentScale = ContentScale.FillWidth,
                                painter = painterResource(item),
                                contentDescription = ""
                            )
                        }
                    })


            }

        }

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "Watch Boost 360 features in action.",
                fontSize = 16.sp,
                color = Color(0xFF4A4A4A), fontWeight = FontWeight.Medium
            )

            LazyColumn(modifier = Modifier
                .size(100.dp), content = {
                items(videosData()) {
                    videoDesign(it)
                }
            })
//          val  v= videosData()
//            videoDesign(products = v[0])
//            Spacer(modifier = Modifier.height(10.dp))
//            videoDesign(products = v[0])
//            Spacer(modifier = Modifier.height(10.dp))
//            videoDesign(products = v[0])
//            Spacer(modifier = Modifier.height(10.dp))
//            videoDesign(products = v[0])


        }

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Partner offerings",
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(8.dp))
//
//            HorizontalPager(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//                    .padding(bottom = 10.dp),
//                pageCount = promoBanners().size
//            ) {
//
//                val prom = promoBanners()
//
//                Image(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .wrapContentHeight()
//                        .clip(shape = RoundedCornerShape(10.dp)),
//                    contentScale = ContentScale.FillWidth,
//                    painter = painterResource(id = prom[it]),
//                    contentDescription = ""
//                )
//
//            }

        }


    }

}

@Composable
fun videoDesign(products: Videos) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(top = 22.dp), horizontalArrangement = Arrangement.Center) {
        Image(modifier = Modifier.size(width = 83.dp, height = 52.dp),painter = painterResource(id = products.pic), contentDescription = "")
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = products.texts, fontSize = 12.sp,
                color = Color(0xFF4A4A4A), fontWeight = FontWeight.Medium
            )
            Text(
                text = "Website Chatbot",
                style = TextStyle(
                    fontSize = 11.sp,
                    color = Color(0xFF747474),
                )
            )
        }
    }
}


//@Preview(showSystemUi = true)
@Composable
fun OverlayWithBox() {
    Box() {
        // Background composable
        Surface(color = Color.Gray) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = roomList[0].image),
                contentDescription = ""
            )
        }

        // Overlay composable
        Surface(modifier = Modifier.background(Color.Red)) {
            Image(
                modifier = Modifier.size(width = 150.dp, height = 150.dp),
                painter = painterResource(id = roomList[1].image),
                contentDescription = ""
            )
        }
    }
}
