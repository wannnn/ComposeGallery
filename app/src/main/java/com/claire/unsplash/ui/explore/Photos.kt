package com.claire.unsplash.ui.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.claire.unsplash.R
import com.claire.unsplash.data.uimodel.ExploreData
import com.claire.unsplash.ui.theme.UnsplashTheme
import com.claire.unsplash.ui.theme.white

@Composable
fun PhotoList(
    photos: List<ExploreData.PhotoData>,
    onPhotoClick:(data: ExploreData.PhotoData) -> Unit
) {
    LazyColumn {
        itemsIndexed(photos) { index, item ->
            PhotoItem(item, onPhotoClick)
        }
    }
}

@Composable
fun PhotoItem(
    data: ExploreData.PhotoData,
    onPhotoClick:(data: ExploreData.PhotoData) -> Unit
) {
    Box(
        modifier = Modifier.clickable {
            onPhotoClick.invoke(data)
        },
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = rememberImagePainter(
                data = data.url,
                builder = {
                    crossfade(true)
                    placeholder(R.drawable.placeholder)
                }
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().aspectRatio(4f/3f),
            contentScale = ContentScale.Crop
        )
        Text(
            text = data.author,
            modifier = Modifier.padding(start = 15.dp, bottom = 15.dp),
            fontSize = 14.sp,
            color = white,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.DarkGray,
                    offset = Offset(6F, 8F),
                    blurRadius = 6F
                )
            )
        )
    }
}

@Preview
@Composable
fun PhotoPreview() {
    UnsplashTheme {
        PhotoItem(photosData1[0]) {}
    }
}