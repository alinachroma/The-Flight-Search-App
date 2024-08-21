package com.example.flightsearchapp.ui.viewmodel

import com.example.flightsearchapp.model.Airport

data class FlightSearchUiState(
    val searchText: String = "",
    val isSearching: Boolean = false,
    val airports: List<Airport> = emptyList(),
    val isAirportSelected: Boolean = false,
    val selectedAirport: Airport? = null
)