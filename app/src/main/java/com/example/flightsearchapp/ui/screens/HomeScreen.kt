package com.example.flightsearchapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.flightsearchapp.R
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.model.FavoriteRoute
import com.example.flightsearchapp.ui.components.AirportInfoItem
import com.example.flightsearchapp.ui.components.RouteItem
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
        modifier = modifier
            .fillMaxSize(),
    ) {
        TextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = stringResource(R.string.user_input)) }
        )
        Spacer(modifier = Modifier.height(16.dp))
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
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(favorites) { favoriteRoute ->
                    airports.find { it.iataCode == favoriteRoute.departureIata
                    }?.let {
                        airport -> airports.find { it.iataCode == favoriteRoute.destinationIata }?.name
                            ?.let {
                            RouteItem(
                                departureIata = favoriteRoute.departureIata,
                                destinationIata = favoriteRoute.destinationIata,
                                departureName = airport.name,
                                destinationName = it,
                                onFavoriteRouteClicked = onFavoriteRouteClicked,
                                isFavoriteButtonFilled = isFavoriteButtonFilled,
                            )
                        }
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(airports) { airport ->
                    Row(modifier = Modifier
                        .clickable { onAirportSelected(airport) }
                    ) {
                        AirportInfoItem(
                            modifier = Modifier,
                            iataCode = airport.iataCode,
                            name = airport.name
                        )
                    }
                }
            }
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
