package com.example.flightsearchapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearchapp.ui.items.FlightSearchTopAppBar
import com.example.flightsearchapp.ui.screens.HomeScreen
import com.example.flightsearchapp.ui.viewmodel.FlightSearchViewModel

@Composable
fun FlightSearchApp(
    modifier: Modifier = Modifier
) {
    val viewModel: FlightSearchViewModel = viewModel(factory = FlightSearchViewModel.Factory)
    val flightSearchUiState = viewModel.flightSearchUiState.collectAsState()

    Scaffold(
        topBar = { FlightSearchTopAppBar() },
        content = { contentPadding ->
            Surface {
                HomeScreen(
                    modifier = modifier.padding(contentPadding),
                    searchText = flightSearchUiState.value.searchText,
                    airports = flightSearchUiState.value.airports,
                    isSearching = flightSearchUiState.value.isSearching,
                    onSearchTextChange = viewModel::onSearchTextChange,
                    isAirportSelected = flightSearchUiState.value.isAirportSelected,
                    onAirportSelected = viewModel::onAirportClick,
                    selectedAirport = flightSearchUiState.value.selectedAirport
                )
            }
        }
    )
}