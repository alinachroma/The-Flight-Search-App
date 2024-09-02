package com.example.flightsearchapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.flightsearchapp.R
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.model.FavoriteRoute
import com.example.flightsearchapp.ui.components.AirportsListItem
import com.example.flightsearchapp.ui.components.FavoriteRoutesItem
import com.example.flightsearchapp.ui.components.FlightSearchTextField
import com.example.flightsearchapp.ui.components.RoutesForSelectedAirportItem
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.emptyAirportData
import com.example.flightsearchapp.utils.fakeAirportsData

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    searchText: String,
    airports: List<Airport>,
    favorites: List<FavoriteRoute>,
    isSearching: Boolean,
    onSearchTextChange: (String) -> Unit,
    onAirportSelected: (Airport) -> Unit,
    isAirportSelected: Boolean,
    arrivalsForSelectedAirport: List<Airport>,
    onFavoriteRouteClicked: (FavoriteRoute) -> Unit,
    isFavoriteButtonFilled: (FavoriteRoute) -> Boolean,
    selectedAirport: Airport?
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        FlightSearchTextField(
            searchText = searchText,
            onSearchTextChange = onSearchTextChange
        )
        Spacer(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.padding_medium))
        )
        if (isSearching) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        if (isAirportSelected) {
            RoutesForSelectedAirportItem(
                arrivalsForSelectedAirport = arrivalsForSelectedAirport,
                selectedAirport = selectedAirport ?: emptyAirportData,
                onFavoriteRouteClicked = onFavoriteRouteClicked,
                isFavoriteButtonFilled = isFavoriteButtonFilled
            )
        } else if (searchText.isBlank()) {
            FavoriteRoutesItem(
                favorites = favorites,
                airports = airports,
                onFavoriteRouteClicked = onFavoriteRouteClicked,
                isFavoriteButtonFilled = isFavoriteButtonFilled
            )
        } else {
            AirportsListItem(
                airports = airports,
                onAirportSelected = onAirportSelected
            )
        }
    }
}

@ThemePreviews
@Composable
fun HomeScreenPreview() {
    FlightSearchAppTheme {
        HomeScreen(
            searchText = "M",
            airports = fakeAirportsData,
            isSearching = false,
            onSearchTextChange = { },
            isAirportSelected = false,
            onAirportSelected = { },
            selectedAirport = fakeAirportsData.first(),
            arrivalsForSelectedAirport = fakeAirportsData,
            onFavoriteRouteClicked = {},
            isFavoriteButtonFilled = { true },
            favorites = emptyList()
        )
    }
}
