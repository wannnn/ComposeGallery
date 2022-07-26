package com.claire.unsplash.ui.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.claire.unsplash.ui.theme.white

@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 32.dp, bottom = 12.dp, start = 16.dp),
        color = white,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}