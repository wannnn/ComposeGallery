package com.claire.unsplash.data.uimodel.explore

import com.claire.unsplash.data.uimodel.PhotoData

data class ExploreData(
    val tabs: List<TabData> = listOf()
) {
    data class TabData(
        val tabName: String = "",
        val photos: List<PhotoData> = listOf()
    )
}
