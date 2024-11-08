package com.androiddev.msaassignment.network

import com.androiddev.msaassignment.model.FoursquareResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface FoursquareApiService {
    @GET("places/search")
    suspend fun searchPlaces(
        @Header("Authorization") apiKey: String,
        @Query("query") query: String,
        @Query("ll") latlong: String,
        @Query("radius") radius: Int = 1500 // Default radius in meters
    ): FoursquareResponse
}