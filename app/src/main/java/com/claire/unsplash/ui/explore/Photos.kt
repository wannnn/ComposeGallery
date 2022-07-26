package com.claire.unsplash.ui.explore

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.claire.unsplash.R
import com.claire.unsplash.data.uimodel.PhotoData
import com.claire.unsplash.data.uimodel.explore.photosData1
import com.claire.unsplash.ui.theme.UnsplashTheme
import com.claire.unsplash.ui.theme.white

@Composable
fun PhotoList(
    photos: List<PhotoData>,
    onPhotoClick: (data: PhotoData) -> Unit
) {
    LazyColumn {
        itemsIndexed(photos) { index, item ->
            ExplorePhotoItem(item, onPhotoClick)
        }
    }
}

@Composable
fun ExplorePhotoItem(
    data: PhotoData,
    onPhotoClick: (data: PhotoData) -> Unit
) {
    Box(
        modifier = Modifier.clickable {
            onPhotoClick.invoke(data)
        },
        contentAlignment = Alignment.BottomStart
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data.url)
                .placeholder(R.drawable.placeholder)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(4f / 3f),
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
        ExplorePhotoItem(photosData1[0]) {}
    }
}