package com.claire.unsplash.data.repo

import com.claire.unsplash.data.model.Photographer
import com.claire.unsplash.data.model.photographer.Photos


interface AppRepo {

    suspend fun getPhotographer(name: String): Result<Photographer>

    suspend fun getPhotographerPhotos(name: String): Result<List<Photos>>

//    suspend fun getPhotographerLikes()
//
//    suspend fun getPhotographerCollections()

}