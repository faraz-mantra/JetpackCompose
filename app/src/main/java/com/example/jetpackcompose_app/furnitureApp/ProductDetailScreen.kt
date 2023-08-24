package com.example.jetpackcompose_app.furnitureApp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_app.R
import com.nameisjayant.projects.furniture.data.Rooms
import com.nameisjayant.projects.furniture.data.roomList

class ProductDetailScreen {

    @Preview
    @Composable
    fun Details() {
        StackImage()
        Layers()
    }

    @Composable
    fun RoomsView(rooms: Rooms) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Image(painter = painterResource(id = rooms.image), contentDescription = "")

        }

    }

    @Composable
    fun RoomsScroller() {

        LazyRow(Modifier.padding(end = 16.dp),content = {
            items(roomList) {
                RoomsView(rooms = it)

            }
        })

    }

    @Composable
    fun Banner() {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "",
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
                .fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
    }

    @Composable
    fun StackImage() {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.product_four),
                contentDescription = "", modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.FillWidth
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    tint = Color.Black,
                    modifier = Modifier.size(32.dp),
                    contentDescription = ""
                )
                Image(
                    painter = painterResource(id = R.drawable.love),
                    contentDescription = ""
                )

            }

        }

    }

    @Composable
    fun Layers() {
        Box(
            modifier = Modifier
                .padding(top = 330.dp)
                .fillMaxSize()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topEnd = 26.dp, topStart = 26.dp)
                )
        ) {
            LazyColumn(modifier = Modifier.padding(20.dp, bottom = 100.dp)) {
                item {
                    ProductHeaderSection()
                    Banner()
                    RoomsScroller()

                }
            }

            Row(
                modifier = Modifier
                    .align(BottomCenter)
                    .padding(16.dp)
            ) {
                TextButton(
                    onClick = { /*TODO*/ },
                    border = BorderStroke(2.dp, color = Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(.5f)
                ) {
                    Text(text = "Add to Cart", fontSize = 22.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                TextButton(
                    onClick = { /*TODO*/ },
                    border = BorderStroke(2.dp, color = Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(.5f)
                ) {
                    Text(text = "Add to Wishlist", fontSize = 22.sp)
                }
            }
        }
    }

    @Composable
    fun ProductHeaderSection() {
        Text(
            text = "Jan Sflanaganvik sofa",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium, modifier = Modifier.padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "${"600 usd"}",
                fontSize = 24.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )
            TextButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.size(36.dp),
                border = BorderStroke(2.dp, color = Color.LightGray)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                )
            }

            Text(
                text = "0", fontSize = 26.sp,
                modifier = Modifier
                    .padding(8.dp)
                    .align(CenterVertically)
            )

            TextButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.size(36.dp),
                border = BorderStroke(2.dp, color = Color.LightGray)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
            }

        }
    }
}