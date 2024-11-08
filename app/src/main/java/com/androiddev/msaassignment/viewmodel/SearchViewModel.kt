package com.androiddev.msaassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.msaassignment.model.FoursquarePlace
import com.androiddev.msaassignment.repository.SearchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val repository = SearchRepository()
    private val _results = MutableStateFlow<List<FoursquarePlace>>(emptyList())
    val results: StateFlow<List<FoursquarePlace>> = _results

    fun searchNearby() {
        viewModelScope.launch {
            val location = "28.631080,77.218310" // Coordinates for example; replace with actual location if needed
            val pizzaResults = repository.searchPlaces("pizza", location)
            val juiceResults = repository.searchPlaces("juice", location)
            _results.value = pizzaResults + juiceResults
        }
    }
}