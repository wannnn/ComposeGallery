package com.claire.unsplash.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
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
        Image(
            painter = rememberImagePainter(
                data = data.url,
                builder = {
                    crossfade(true)
                    placeholder(R.drawable.placeholder)
                }
            ),
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