package com.claire.composegallery.di

import com.claire.composegallery.data.AppRepoImp
import com.claire.composegallery.data.network.ApiService
import com.claire.composegallery.data.network.RetrofitManager
import com.claire.composegallery.data.repo.AppRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton

@ExperimentalSerializationApi
@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideService(): ApiService {
        return RetrofitManager().apiService
    }

    @Singleton
    @Provides
    fun provideAppRepo(service: ApiService): AppRepo {
        return AppRepoImp(service)
    }
}