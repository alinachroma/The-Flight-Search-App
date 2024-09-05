package com.example.flightsearchapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.flightsearchapp.R
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.model.FavoriteRoute
import com.example.flightsearchapp.ui.components.AirportsListItem
import com.example.flightsearchapp.ui.components.FavoriteRoutesItem
import com.example.flightsearchapp.ui.components.FlightSearchTextField
import com.example.flightsearchapp.ui.components.FlightSearchTitleItem
import com.example.flightsearchapp.ui.components.RoutesForSelectedAirportItem
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.emptyAirportData
import com.example.flightsearchapp.utils.fakeAirportsData

@OptIn(ExperimentalAnimationApi::class)
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
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainerHigh),
    ) {
        FlightSearchTextField(
            searchText = searchText,
            onSearchTextChange = onSearchTextChange
        )
        if (isSearching) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        if (isAirportSelected) {
            if (selectedAirport != null) {
                FlightSearchTitleItem(
                    text = stringResource(
                        R.string.flights_from,
                        selectedAirport.iataCode
                    ),
                )
            }
        }
        AnimatedVisibility(
            visible = isAirportSelected
        ) {
            RoutesForSelectedAirportItem(
                arrivalsForSelectedAirport = arrivalsForSelectedAirport,
                selectedAirport = selectedAirport ?: emptyAirportData,
                onFavoriteRouteClicked = onFavoriteRouteClicked,
                isFavoriteButtonFilled = isFavoriteButtonFilled,
                modifier = Modifier.animateEnterExit(
                    enter = expandVertically(
                        animationSpec = tween(500),
                        expandFrom = Alignment.Top
                    ) + fadeIn(
                        initialAlpha = 0.3f
                    ),
                    exit = shrinkVertically()
                )
            )
        }
        if (searchText.isBlank() && !isAirportSelected) {
            FlightSearchTitleItem(text = stringResource(id = R.string.favorite_routes))
        }
        AnimatedVisibility(
            visible = searchText.isBlank() && !isAirportSelected
        ) {
            FavoriteRoutesItem(
                favorites = favorites,
                airports = airports,
                onFavoriteRouteClicked = onFavoriteRouteClicked,
                isFavoriteButtonFilled = isFavoriteButtonFilled,
                modifier = Modifier.animateEnterExit(
                    enter = expandVertically(animationSpec = tween(500)),
                    exit = shrinkVertically()
                )
            )
        }
        if (searchText.isNotBlank() && !isAirportSelected) {
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
