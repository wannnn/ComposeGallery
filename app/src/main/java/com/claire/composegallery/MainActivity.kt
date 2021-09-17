package com.claire.composegallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalPagerApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PhotographerPage("yann_allegre")
                }
            }
        }
    }
}

val fakeImgs = listOf(
    "https://picsum.photos/id/1018/800/500",
    "https://picsum.photos/id/1015/800/500",
    "https://picsum.photos/id/100/800/500",
    "https://picsum.photos/id/1000/800/500",
    "https://picsum.photos/id/1001/800/500",
    "https://picsum.photos/id/1014/800/500",
    "https://picsum.photos/id/102/800/500",
    "https://picsum.photos/id/1027/800/500",
    "https://picsum.photos/id/103/800/500",
    "https://picsum.photos/id/1033/800/500",
)

@Composable
fun DiaryList() {
    LazyColumn(
        state = rememberLazyListState()
    ) {
        items(fakeImgs) { img ->
            DiaryCard(img)
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