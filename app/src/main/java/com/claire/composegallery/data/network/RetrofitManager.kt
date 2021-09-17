package com.claire.composegallery.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@ExperimentalSerializationApi
class RetrofitManager {

    private val json = Json { ignoreUnknownKeys = true }
    private val client = OkHttpClient.Builder().addInterceptor {
        it.proceed(
        it.request().newBuilder().apply {
            addHeader(AUTHORIZATION, CLIENT_ID)
        }.build()
    )

    }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory(TYPE_JSON.toMediaType()))
        .client(client)
        .build()

    val apiService: ApiService by lazy { retrofit.create(ApiService::class.java) }

    companion object {
        private const val BASE_URL: String = "https://api.unsplash.com/"
        private const val TYPE_JSON: String = "application/json"
        private const val AUTHORIZATION: String = "Authorization"
        private const val CLIENT_ID: String = "Client-ID 5htuSvZ8-6ES6XDbaHjmO1C8iDvGOJYpv8i2945gIPg"
    }
}