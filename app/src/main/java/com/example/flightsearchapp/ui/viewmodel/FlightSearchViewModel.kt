package com.example.flightsearchapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearchapp.FlightSearchApplication
import com.example.flightsearchapp.data.AirportRepository
import com.example.flightsearchapp.data.FavoriteRouteRepository
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.model.FavoriteRoute
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlightSearchViewModel(
    private val airportRepository: AirportRepository,
    private val favoriteRouteRepository: FavoriteRouteRepository
) : ViewModel() {

    private val _flightSearchUiState = MutableStateFlow(FlightSearchUiState())
    val flightSearchUiState = _flightSearchUiState.asStateFlow()

    fun onSearchTextChange(text: String) {
        _flightSearchUiState.update { uiState ->
            uiState.copy(
                searchText = text,
                isAirportSelected = false
            )
        }
        viewModelScope.launch {
            airportRepository.getAirportsByQuery(query = text)
                .collect { airports ->
                    _flightSearchUiState.update { uiState ->
                        uiState.copy(
                            airports = airports
                        )
                    }
                }
        }
        println(flightSearchUiState.value)
    }

    fun onAirportClick(airport: Airport) {
        _flightSearchUiState.update { uiState ->
            uiState.copy(
                isAirportSelected = true,
                selectedAirport = airport,
            )
        }
        println(flightSearchUiState.value)
    }

    fun getArrivalsForSelectedAirport(selectedAirport: Airport): Flow<List<Airport>> =
        airportRepository.getArrivalsForSelectedAirport(
            iataCode = selectedAirport.iataCode,
            name = selectedAirport.name
        )

    fun validateFavorite(favoriteRoute: FavoriteRoute): Boolean =
        _flightSearchUiState.value.favoriteRoutes
            .any {
                it.departureIata == favoriteRoute.departureIata
                        && it.destinationIata == favoriteRoute.destinationIata
            }

    fun markOrUnmarkAsFavorite(favoriteRoute: FavoriteRoute) =
        viewModelScope.launch {
            val isFavorite = validateFavorite(favoriteRoute)
            if (isFavorite) {
                favoriteRouteRepository.deleteFavoriteRoute(favoriteRoute.departureIata, favoriteRoute.destinationIata)
                _flightSearchUiState.update { uiState ->
                    uiState.copy(
                        favoriteRoutes = favoriteRouteRepository.getFavoriteRoutes().first()
                    )
                }
                _flightSearchUiState.update { uiState ->
                    uiState.copy(
                        isFavoriteButtonFilled = false
                    )
                }
            } else {
                favoriteRouteRepository.insertFavoriteRoute(favoriteRoute)
                _flightSearchUiState.update { uiState ->
                    uiState.copy(
                        favoriteRoutes = favoriteRouteRepository.getFavoriteRoutes().first()
                    )
                }
                _flightSearchUiState.update { uiState ->
                    uiState.copy(
                        isFavoriteButtonFilled = true
                    )
                }
            }
        }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FlightSearchApplication)
                val airportRepository = application.airportRepository
                val favoriteRouteRepository = application.favoriteRouteRepository
                FlightSearchViewModel(
                    airportRepository = airportRepository,
                    favoriteRouteRepository = favoriteRouteRepository
                )
            }
        }
    }
}



