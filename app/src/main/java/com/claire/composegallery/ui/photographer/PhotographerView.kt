package com.claire.composegallery.ui.photographer

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.claire.composegallery.R
import com.claire.composegallery.data.model.Photographer
import com.claire.composegallery.data.model.photographer.Photos
import com.claire.composegallery.ui.theme.ComposeGalleryTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import moe.tlaster.nestedscrollview.VerticalNestedScrollView
import moe.tlaster.nestedscrollview.rememberNestedScrollViewState


private var photographerName: String = ""


@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun PhotographerPage(
    name: String,
    viewModel: PhotographerViewModel = viewModel()
) {
    photographerName = name

    viewModel.getPhotographer(photographerName)

    val photographer = viewModel.photographer.observeAsState().value ?: Photographer()

    Scaffold(topBar = {
        MyAppBar(photographer.name)
    }) {
        val nestedScrollViewState = rememberNestedScrollViewState()
        VerticalNestedScrollView(
            state = nestedScrollViewState,
            header = {
                Column {
                    PhotographerInfo(photographer)
                }
            },
            content = { Pager() }
        )
    }
}

@Composable
fun MyAppBar(name: String) {

    TopAppBar(
        elevation = 8.dp,
        content = {
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(start = 12.dp)
            )
        }
    )
}

@Composable
fun PhotographerInfo(photographer: Photographer) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = rememberImagePainter(
                data = photographer.profile_image.large,
                builder = {
                    crossfade(true)
                    transformations(CircleCropTransformation())
                    placeholder(R.drawable.ic_round_person_add_24)
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )

        ConnectedBox(listOf(
            R.drawable.ic_round_person_add_24,
            R.drawable.ic_round_mail_24,
            R.drawable.ic_instagram))
    }

    ImgText(R.drawable.ic_round_location_on_24, photographer.location)

    Text(
        text = photographer.bio,
        modifier = Modifier.padding(16.dp)
    )
}

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun Pager(
    viewModel: PhotographerViewModel = viewModel()
) {

    viewModel.getPhotographerPhotos(photographerName)

    val photos = viewModel.photos.observeAsState().value.orEmpty()

    val scope = rememberCoroutineScope()

    val tabs = listOf(
        R.drawable.ic_round_photo_24,
        R.drawable.ic_round_favorite_24,
        R.drawable.ic_round_layers_24
    )

    val pagerState = rememberPagerState(pageCount = tabs.size)

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }
        ) {
            // Add tabs for all of our pages
            tabs.forEachIndexed { index, icon ->
                Tab(
                    icon = { Image(painter = painterResource(icon), contentDescription = null) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                )
            }
        }

        HorizontalPager(state = pagerState) { page ->
            when(page) {
                0 -> {
                    LazyVerticalGrid(
                        cells = GridCells.Fixed(2),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        items(photos.size) { index ->
                            Photos(photos[index])
                        }
                    }
                }
                1 -> {
                    LazyColumn {
                        items(2) {
                            Collections()
                        }
                    }
                }
                2 -> {
                    LazyColumn {
                        items(3) {
                            Collections()
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun ConnectedBox(icons: List<Int>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        icons.forEach {
            OutlinedButton(
                onClick = {  },
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(8),
                modifier = Modifier.shadow(3.dp)
            ) {
                Image(
                    painter = painterResource(it),
                    contentDescription = null,
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}

@Composable
fun ImgText(img: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Image(
            painter = painterResource(img),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.size(5.dp))
        Text(text = text)
    }
}

@Composable
fun Photos(photo: Photos) {
    Image(
        painter = rememberImagePainter(
            data = photo.urls.imgUrl,
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .aspectRatio(1.5f)
            .fillMaxWidth()
    )
}

@Composable
fun Likes() {

}

@Composable
fun Collections() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = rememberImagePainter(
                data = "https://picsum.photos/id/103/500",
            ),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        
        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(
                    data = "https://picsum.photos/id/103/200",
                ),
                contentDescription = null,
                modifier = Modifier.size(122.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.size(6.dp))

            Image(
                painter = rememberImagePainter(
                    data = "https://picsum.photos/id/103/200",
                ),
                contentDescription = null,
                modifier = Modifier.size(122.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeGalleryTheme {
        PhotographerPage("yann_allegre")
    }
}