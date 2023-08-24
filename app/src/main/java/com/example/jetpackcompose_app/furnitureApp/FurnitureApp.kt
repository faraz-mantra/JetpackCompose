package com.example.jetpackcompose_app.furnitureApp

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_app.MainActivity
import com.example.jetpackcompose_app.R
import com.example.jetpackcompose_app.ui.theme.DarkOrange
import com.nameisjayant.projects.furniture.data.PopularProducts
import com.nameisjayant.projects.furniture.data.Rooms
import com.nameisjayant.projects.furniture.data.categoryList
import com.nameisjayant.projects.furniture.data.popularProductList
import com.nameisjayant.projects.furniture.data.roomList


class FurnitureApp {

    @Preview(showSystemUi = false)
    @Composable
    fun MainView() {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                HeadersView()
                CommonTitle(title = "Categories")
                CategoriesRow()
                CommonTitle(title = "Popular")
                PopularProductsRow()
                Banner()
                CommonTitle(title = "Rooms")
                RoomsScroller()
            }
        }
    }

    @Composable
    fun HeadersView() {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Explore what \nyour home needs",
                fontSize = 26.sp, fontWeight = FontWeight.Light
            )
            Icon(
                painter = painterResource(id = R.drawable.bag),
                contentDescription = "",
                tint = DarkOrange,
                modifier = Modifier
                    .size(height = 36.dp, width = 36.dp)
                    .align(CenterVertically)
            )

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
            Text(modifier = Modifier.clickable(enabled = true, onClick = {}),text = "${title}", fontWeight = FontWeight.Medium, fontSize = 16.sp)
            TextButton(onClick = { }) {
                Text(text = "View all", fontSize = 14.sp, color = DarkOrange)
                Spacer(modifier = Modifier.width(3.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    tint = DarkOrange,
                    modifier = Modifier.size(20.dp),
                    contentDescription = ""
                )
            }

        }
    }

    @Composable
    fun CategoriesScroller(category: com.nameisjayant.projects.furniture.data.Category) {
        Card(
            elevation = CardDefaults.cardElevation(),
            modifier = Modifier
                .size(width = 160.dp, height = 120.dp)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = SpaceBetween,
                verticalAlignment = CenterVertically
            ) {
                Text(text = "${category.title}", fontSize = 20.sp, fontWeight = FontWeight.Light)
                Image(
                    painter = painterResource(id = category.image),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        .fillMaxSize()
                )
            }
        }
    }

    @Composable
    fun CategoriesRow() {
        LazyRow(content = {
            items(categoryList) {
                CategoriesScroller(it)
            }
        })
    }

    @Composable
    fun PopularProductsRow() {
        LazyRow(content = {
            items(popularProductList) {
                PopularProductsScroller(it)
            }
        })
    }

    @Composable
    fun PopularProductsScroller(products: PopularProducts) {
        Card(
            elevation = CardDefaults.cardElevation(),
            modifier = Modifier
                .size(width = 182.dp, height = 270.dp)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = products.image),
                    contentDescription = "",
                    modifier = Modifier.clip(shape = RoundedCornerShape(10.dp))
                )
                Spacer(Modifier.height(15.dp))
                Text(text = products.title, maxLines = 1, fontSize = 20.sp)
                Spacer(Modifier.height(10.dp))
                Text(text = products.price, maxLines = 1, fontSize = 20.sp)
            }
        }
    }

    @Composable
    fun Banner() {
        Box(
//            modifier = Modifier.fillMaxWidth().wrapContentSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .fillMaxSize(),
//                contentScale = ContentScale.FillWidth
            )
        }
    }

    @Composable
    fun RoomsView(rooms: Rooms) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .size(width = 127.dp, height = 195.dp)
        ) {

            Image(painter = painterResource(id = rooms.image), contentDescription = "")

        }

    }

    @Composable
    fun RoomsScroller() {

        LazyRow(content = {
            items(roomList) {
                RoomsView(rooms = it)

            }
        })

    }

}