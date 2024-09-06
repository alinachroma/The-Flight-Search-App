package com.example.flightsearchapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    selectedAirport: Airport?,
    isOnboardingVisible: Boolean,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainerHigh),
    ) {
        if (isSearching) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        FlightSearchTextField(
            searchText = searchText,
            onSearchTextChange = onSearchTextChange
        )
        if (isOnboardingVisible) {
            WelcomeScreen()
        }
        when (searchText.isBlank()) {
            true -> {
                AnimatedVisibility(
                    visible = !isAirportSelected
                ) {
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        if (favorites.isEmpty()) {
                            Text(text = "ADD FAVORITES")
                        } else {
                            FlightSearchTitleItem(text = stringResource(id = R.string.favorite_routes))
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
                    }
                }
            }

            false -> {
                if (!isAirportSelected) {
                    AirportsListItem(
                        airports = airports,
                        onAirportSelected = onAirportSelected
                    )
                }
            }
        }
        AnimatedVisibility(
            visible = isAirportSelected
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                if (selectedAirport != null) {
                    FlightSearchTitleItem(
                        text = stringResource(
                            R.string.flights_from,
                            selectedAirport.iataCode
                        ),
                    )
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
            }
        }
    }
}

@ThemePreviews
@Composable
fun HomeScreenPreview() {
    FlightSearchAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.surfaceContainerHigh
        ) {
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
                favorites = emptyList(),
                isOnboardingVisible = false
            )
        }
    }
}
