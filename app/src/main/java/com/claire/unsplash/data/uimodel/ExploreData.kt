package com.claire.unsplash.data.uimodel

data class ExploreData(
    val tabs: List<TabData> = listOf()
) {
    data class TabData(
        val tabName: String = "",
        val photos: List<PhotoData> = listOf()
    )

    data class PhotoData(
        val url: String = "",
        val author: String = ""
    )
}
