package com.claire.unsplash.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material.icons.twotone.Share
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.claire.unsplash.ui.theme.white
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues

@Composable
fun Appbar() {
    Row(
        modifier = Modifier
            .padding(rememberInsetsPaddingValues(insets = LocalWindowInsets.current.statusBars))
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
            text = "Author Name",
            fontSize = 20.sp,
            color = white
        )

        IconButton(onClick = {

        }) {
            Icon(
                Icons.TwoTone.Share,
                contentDescription = null
            )
        }
    }
}