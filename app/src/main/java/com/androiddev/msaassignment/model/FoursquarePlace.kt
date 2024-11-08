package com.androiddev.msaassignment.model

data class FoursquarePlace(
    val categories: List<Category>,
    val chains: List<Chain>,
    val closed_bucket: String,
    val distance: Int,
    val fsq_id: String,
    val geocodes: Geocodes,
    val link: String,
    val location: Location,
    val name: String,
    val related_places: RelatedPlaces,
    val timezone: String
)