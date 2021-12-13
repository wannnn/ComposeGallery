package com.claire.unsplash.ui.explore

import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.claire.unsplash.ui.theme.white
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun Tabs(
    pagerState: PagerState,
    pages: List<String>
) {

    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        },
        backgroundColor = Color.Transparent
    ) {
        // Add tabs for all of our pages
        pages.forEachIndexed { index, title ->
            Tab(
                text = {
                    Text(
                        text = title,
                        color = white,
                        fontWeight = FontWeight.Bold
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}