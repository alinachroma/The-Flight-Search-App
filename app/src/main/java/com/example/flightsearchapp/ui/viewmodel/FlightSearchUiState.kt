package com.example.flightsearchapp.ui.viewmodel

import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.model.FavoriteRoute

data class FlightSearchUiState(
    val searchText: String = "",
    val isSearching: Boolean = false,
    val airports: List<Airport> = emptyList(),
    val isAirportSelected: Boolean = false,
    val selectedAirport: Airport? = null,
    var favoriteRoutes: List<FavoriteRoute> = emptyList(),
)