@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jetpackcompose_app.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AppBars() {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Compose UI") },
                Modifier.background(color = Color.Yellow),
                navigationIcon = {
                    Image(imageVector = Icons.Default.Menu, contentDescription = "")
                },
                actions = {
                    Image(imageVector = Icons.Default.Search, contentDescription = "")
                    Image(imageVector = Icons.Default.Notifications, contentDescription = "")
                }
            )

        }
    ) {

    }

}