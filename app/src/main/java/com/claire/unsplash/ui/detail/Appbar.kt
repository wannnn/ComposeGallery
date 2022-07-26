package com.claire.unsplash.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material.icons.twotone.IosShare
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.claire.unsplash.ui.theme.white

@Composable
fun Appbar(authorName: String) {
    Row(
        modifier = Modifier
            .statusBarsPadding()
            .height(56.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {

        }) {
            Icon(
                Icons.TwoTone.ArrowBack,
                contentDescription = null
            )
        }

        Text(
            text = authorName,
            fontSize = 20.sp,
            color = white
        )

        IconButton(onClick = {

        }) {
            Icon(
                Icons.TwoTone.IosShare,
                contentDescription = null
            )
        }
    }
}