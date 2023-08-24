package com.example.jetpackcompose_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Preview(showSystemUi = true)
@Composable
fun OtpField() {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        color = Color.White
    ) {
        var otpValue by remember {
            mutableStateOf("")
        }

        BasicTextField(value = otpValue, onValueChange = {
            otpValue = it
        })
        repeat(6) { index ->
            val char = when {
                index >= otpValue.length -> ""
                else -> otpValue[index].toString()
            }
            val isFocused = otpValue.length == index
            Text(
                modifier = Modifier
                    .width(40.dp)
                    .border(
                        if (isFocused) 2.dp
                        else 1.dp,

                        if (isFocused) Color.DarkGray else Color.LightGray, RoundedCornerShape(8.dp)
                    ),
                text = char,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }


}
