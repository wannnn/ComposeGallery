package com.claire.composegallery.data.repo

import com.claire.composegallery.data.model.Photographer
import com.claire.composegallery.data.model.photographer.Photos


interface AppRepo {

    suspend fun getPhotographer(name: String): Result<Photographer>

    suspend fun getPhotographerPhotos(name: String): Result<List<Photos>>

//    suspend fun getPhotographerLikes()
//
//    suspend fun getPhotographerCollections()

}