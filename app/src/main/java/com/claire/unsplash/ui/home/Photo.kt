package com.claire.unsplash.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.FilterVintage
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.claire.unsplash.ui.theme.UnsplashTheme

@Composable
fun Photo() {
    Column {
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "UnSplash",
                    fontWeight = FontWeight.Bold
                )
            },
            backgroundColor = Color.Transparent,
            navigationIcon = {
                IconButton(onClick = {

                }) {
                    Icon(Icons.TwoTone.FilterVintage, contentDescription = null)
                }
            },
            elevation = 0.dp
        )
    }
}

@Composable
fun PhotoList(data: List<String>) {
    LazyColumn {
        items(data.size) { message ->
            Text(text = "")
        }
    }
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PhotoPreview() {
    UnsplashTheme {
        Photo()
    }
}