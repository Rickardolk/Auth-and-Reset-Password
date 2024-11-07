package com.example.myapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapp.R

@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            text = "Home",
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.font)
        )
    }
}