package com.claire.composegallery.data

import com.claire.composegallery.data.model.Photographer
import com.claire.composegallery.data.model.photographer.Photos
import com.claire.composegallery.data.network.ApiService
import com.claire.composegallery.data.repo.AppRepo

class AppRepoImp(private val service: ApiService): AppRepo {

    override suspend fun getPhotographer(name: String): Result<Photographer> {

        return try {

            val result = service.getPhotographer(name)
            Result.success(result)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getPhotographerPhotos(name: String): Result<List<Photos>> {

        return try {

            val result = service.getPhotographerPhotos(name)
            Result.success(result)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}