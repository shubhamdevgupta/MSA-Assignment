package com.androiddev.msaassignment

import com.androiddev.msaassignment.network.FoursquareApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitInstance {
    private const val BASE_URL = "https://api.foursquare.com/v3/"

    // Create a logging interceptor
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Log request and response body
    }

    // Create an OkHttpClient with the logging interceptor
    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    // Retrofit instance
    val api: FoursquareApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client) // Add the OkHttp client with logging
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FoursquareApiService::class.java)
    }
}
