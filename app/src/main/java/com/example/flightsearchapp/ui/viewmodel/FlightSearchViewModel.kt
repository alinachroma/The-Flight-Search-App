package com.example.flightsearchapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearchapp.FlightSearchApplication
import com.example.flightsearchapp.data.AirportRepository
import com.example.flightsearchapp.model.Airport
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlightSearchViewModel(
    private val airportRepository: AirportRepository
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
    }

    fun onAirportClick(airport: Airport) {
        _flightSearchUiState.update {
            uiState -> uiState.copy(
                isAirportSelected = true,
                selectedAirport = airport
            )
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FlightSearchApplication)
                val airportRepository = application.airportRepository
                FlightSearchViewModel(airportRepository = airportRepository)
            }
        }
    }
}



