package com.claire.unsplash.data.model.photographer

import kotlinx.serialization.Serializable

@Serializable
data class Photos(
    val id: String = "",
    val urls: Urls = Urls(),
    val links: Links = Links()
) {

    @Serializable
    data class Urls(
        private val raw: String = "",
    ) {
        val imgUrl: String get() = raw.plus("&w=750&dpr=2")
    }

    @Serializable
    data class Links(
        val download_location: String = ""
    )
}