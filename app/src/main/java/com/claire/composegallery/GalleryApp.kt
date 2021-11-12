package com.claire.composegallery

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.claire.composegallery.ui.photographer.PhotographerPage
import com.claire.composegallery.ui.theme.ComposeGalleryTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun GalleryApp() {
    ComposeGalleryTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            PhotographerPage("yann_allegre")
        }
    }
}

@Composable
fun DiaryCard(fakeImgs: String = "") {
    Column(
        Modifier.padding(16.dp)
    ) {
        Header()
        Spacer(Modifier.size(16.dp))
        Card(elevation = 4.dp, modifier = Modifier
            .height(height = 230.dp)
            .fillMaxWidth()) {
            Image(
                painter = rememberImagePainter(
                    data = fakeImgs,
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun Header() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(
                data = "https://picsum.photos/150",
                builder = {
                    transformations(CircleCropTransformation())
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.size(16.dp))
        Column {
            Text("Claire")
            Text("2021/7/31")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeGalleryTheme {
        DiaryCard()
    }
}