package com.claire.unsplash.di

import com.claire.unsplash.data.AppRepoImp
import com.claire.unsplash.data.network.ApiService
import com.claire.unsplash.data.network.RetrofitManager
import com.claire.unsplash.data.repo.AppRepo
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