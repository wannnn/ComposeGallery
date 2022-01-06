package com.claire.unsplash.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.claire.unsplash.data.uimodel.search.categories
import com.claire.unsplash.data.uimodel.search.discovers
import com.claire.unsplash.ui.search.*
import com.claire.unsplash.ui.theme.UnsplashTheme
import com.claire.unsplash.ui.theme.black

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Search() {

    LazyColumn(
        modifier = Modifier.fillMaxSize().background(color = black),
        content = {

            stickyHeader {
                SearchBar()
            }

            item {
                Title("Browse by Category")
                CategoryGrid(categories, {})
            }

            item {
                Title("Discover")
            }

            items(discovers.chunked(2)) { subList ->
                DiscoverGrid(subList, {})
            }
        }
    )
}

@Preview
@Composable
fun PreviewSearch() {
    UnsplashTheme {
        Search()
    }
}