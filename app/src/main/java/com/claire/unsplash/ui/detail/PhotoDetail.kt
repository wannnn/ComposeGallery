package com.claire.unsplash.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Info
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.claire.unsplash.R
import com.claire.unsplash.ui.theme.black

@Composable
fun PhotoDetail() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = black),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Appbar("ABC")

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://picsum.photos/id/106/400/300")
                .placeholder(R.drawable.placeholder)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        IconButton(
            onClick = {

            },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        ) {
            Icon(
                Icons.TwoTone.Info,
                contentDescription = null
            )
        }

    }
}