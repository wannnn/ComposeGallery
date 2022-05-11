package com.claire.unsplash.ui.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.claire.unsplash.R
import com.claire.unsplash.data.uimodel.PhotoData
import com.claire.unsplash.ui.theme.white

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DiscoverGrid(
    subList: List<PhotoData>,
    onPhotoClick: (data: PhotoData) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        content = {
            subList.forEach {
                val modifier = Modifier
                    .height(300.dp)
                    .weight(1f)
                    .padding(1.dp)

                DiscoverPhotoItem(modifier, it, onPhotoClick)
            }
        }
    )
}

@Composable
fun DiscoverPhotoItem(
    modifier: Modifier,
    data: PhotoData,
    onPhotoClick: (data: PhotoData) -> Unit
) {
    Box(
        modifier = modifier.clickable {
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
            modifier = Modifier.fillMaxHeight(),
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