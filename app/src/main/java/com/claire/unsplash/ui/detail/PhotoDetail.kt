package com.claire.unsplash.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.claire.unsplash.ui.theme.black

@Composable
fun PhotoDetail() {
    Column(
        modifier = Modifier.background(color = black)
    ) {
        Appbar()
    }
}