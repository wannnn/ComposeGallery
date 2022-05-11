package com.claire.unsplash.ui.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.claire.unsplash.R
import com.claire.unsplash.data.uimodel.search.SearchData
import com.claire.unsplash.ui.theme.white

@Composable
fun CategoryGrid(
    categories: List<SearchData.CategoryData>,
    onCategoryClick: () -> Unit
) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(categories) { index, item ->
            CategoryItem(item, onCategoryClick)
        }
    }
}

@Composable
fun CategoryItem(
    data: SearchData.CategoryData,
    onCategoryClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(start = 4.dp, end = 4.dp)
            .clip(RoundedCornerShape(7.dp))
            .clickable {
                onCategoryClick.invoke()
            },
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data.url)
                .placeholder(R.drawable.placeholder)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier.size(128.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = data.categoryName,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = white,
        )
    }
}