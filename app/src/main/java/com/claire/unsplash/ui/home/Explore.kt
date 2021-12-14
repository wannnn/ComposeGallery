package com.claire.unsplash.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.claire.unsplash.ui.explore.MyAppbar
import com.claire.unsplash.ui.explore.Tabs
import com.claire.unsplash.ui.explore.PhotoList
import com.claire.unsplash.ui.explore.exploreFakeData
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun Explore(
    action: (destination: Destinations) -> Unit
) {

    val fakeData = exploreFakeData

    val pagerState = rememberPagerState()

    HorizontalPager(
        count = fakeData.tabs.size,
        modifier = Modifier.fillMaxWidth(),
        state = pagerState,
    ) { page ->
        PhotoList(
            fakeData.tabs[page].photos,
            onPhotoClick = {
                action.invoke(Destinations.PhotoDetail)
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        MyAppbar()
        Tabs(pagerState, fakeData.tabs.map { it.tabName })
    }

}

