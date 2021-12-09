package com.claire.unsplash.data.network

import com.claire.unsplash.data.model.Photographer
import com.claire.unsplash.data.model.photographer.Photos
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/users/{userName}")
    suspend fun getPhotographer(@Path ("userName") name: String): Photographer

    @GET("/users/{userName}/photos")
    suspend fun getPhotographerPhotos(@Path ("userName") name: String): List<Photos>

    @GET("/users/{userName}/likes")
    suspend fun getPhotographerLikes(@Path ("userName") name: String)

    @GET("/users/{userName}/collections")
    suspend fun getPhotographerCollections(@Path ("userName") name: String)

}