package com.claire.unsplash.data.uimodel.search

import com.claire.unsplash.data.uimodel.PhotoData

data class SearchData(
    val category: CategoryData = CategoryData(),
    val discoverPhoto: PhotoData = PhotoData()
) {
    data class CategoryData(
        val categoryName: String = "",
        val url: String = ""
    )
}
