//package com.example.jetpackcompose_app.screens
//
//import android.annotation.SuppressLint
//import android.graphics.drawable.shapes.OvalShape
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.pager.HorizontalPager
//import androidx.compose.foundation.pager.PagerState
//import androidx.compose.foundation.pager.rememberPagerState
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.RectangleShape
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//
//
//@Preview(showSystemUi = true)
//@kotlin.OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun HorizontalViewPagerDemo() {
//    val pagerState = rememberPagerState()
//    val pageCount = 5
//    val scope = rememberCoroutineScope()
//
//    //Method-1
////    scope.launch {
////        delay(2000)
////        pagerState.animateScrollToPage(page = (pagerState.currentPage + 1) % (pageCount))
////    }
//
//    // or
//
////  Method-2:  With launchedEffect
//
////    LaunchedEffect(Unit) {
////        while (true) {
////            delay(2000)
////            pagerState.animateScrollToPage(page = (pagerState.currentPage + 1) % (pageCount))
////        }
////
////    }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        HorizontalPager(
//            pageCount = pageCount,
//            modifier = Modifier.align(Alignment.Center),
//            state = pagerState
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(Alignment.Center), contentAlignment = Alignment.Center
//            ) {
//                Text(text = "$it", fontSize = 32.sp)
//            }
//
//        }
//        Column(
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(6.dp)
//        ) {
//
//            TextButton(
//                onClick = {scope.launch {
//                    pagerState.animateScrollToPage(page = (pagerState.currentPage + 1) % (pageCount))
//                } },
//                modifier = Modifier.background(color = Color.Gray), shape = CircleShape) {
//                Text(text = "Go to next slide", fontSize = 14.sp, color = Color.White)
//
//            }
//            Row(
//                modifier = Modifier
//                    .padding(bottom = 10.dp)
//            ) {
//                repeat(pageCount) {
//                    Indicators(isSelected = (pagerState.currentPage == it))
//                }
//            }
//        }
//
//
//    }
//}
//
//@Composable
//fun Indicators(isSelected: Boolean) {
//    Box(
//        modifier = Modifier
//            .padding(2.dp)
//            .background(color = if (isSelected) Color.Cyan else Color.Gray, shape = CircleShape)
//            .size(15.dp)
//    )
//}