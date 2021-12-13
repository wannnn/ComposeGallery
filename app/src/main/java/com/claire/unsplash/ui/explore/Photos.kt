package com.claire.unsplash.ui.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.claire.unsplash.R
import com.claire.unsplash.ui.theme.UnsplashTheme
import com.claire.unsplash.ui.theme.white

@Composable
fun PhotoList() {
    LazyColumn {
        items(10) {
            PhotoItem()
        }
    }
}

@Composable
fun PhotoItem() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.home_banner),
            contentDescription = null
        )
        Text(
            text = "Testttttt"
        )
    }
}

@Preview
@Composable
fun PhotoPreview() {
    UnsplashTheme {
        PhotoItem()
    }
}