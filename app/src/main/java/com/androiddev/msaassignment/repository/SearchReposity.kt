package com.androiddev.msaassignment.repository

import com.androiddev.msaassignment.RetrofitInstance
import com.androiddev.msaassignment.model.FoursquarePlace

class SearchRepository {
    private val apiKey = "fsq3H6LE6hl70Y2WD5D1xq5h3XUlNE6KL9TRdwJu/Ln1h1E="

    suspend fun searchPlaces(query: String, latLong: String): List<FoursquarePlace> {
        return RetrofitInstance.api.searchPlaces(
            apiKey = apiKey,
            query = query,
            latlong = latLong
        ).results
    }
}