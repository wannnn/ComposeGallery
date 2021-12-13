package com.claire.unsplash.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.claire.unsplash.ui.explore.MyAppbar
import com.claire.unsplash.ui.explore.Tabs
import com.claire.unsplash.ui.explore.PhotoList
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun Explore() {

    val tabs = listOf("Editorial", "Holidays", "Blockchain", "Wallpapers", "Architecture", "Nature")
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = tabs.size,
        state = pagerState,
    ) { page ->
        PhotoList()
    }

    Column {
        MyAppbar()
        Tabs(pagerState, tabs)
    }

}