package com.androiddev.msaassignment

import com.androiddev.msaassignment.network.FoursquareApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.foursquare.com/v3/"

    val api: FoursquareApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FoursquareApiService::class.java)
    }
}
