package com.claire.unsplash.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Photographer(
    val id: String = "",
    val profile_image: ProfileImage = ProfileImage(),
    val name: String = "",
    val bio: String = "",
    val location: String = "",
) {

    @Serializable
    data class ProfileImage(
        val large: String = ""
    )
}