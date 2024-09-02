package com.example.flightsearchapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.model.FavoriteRoute

@Composable
fun FavoriteRoutesItem(
    modifier: Modifier = Modifier,
    favorites: List<FavoriteRoute>,
    airports: List<Airport>,
    onFavoriteRouteClicked: (FavoriteRoute) -> Unit,
    isFavoriteButtonFilled: (FavoriteRoute) -> Boolean,
    ) {
    LazyColumn(
        modifier = modifier,
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
}

@ThemePreviews
@Composable
fun FavoriteRoutesItemPreview() {
    FlightSearchAppTheme {
        FavoriteRoutesItem(
            favorites = listOf(
                FavoriteRoute(
                    id = 86,
                    departureIata = "DUS",
                    destinationIata = "MUC"
                )
            ),
            airports = fakeAirportsData,
            onFavoriteRouteClicked = {},
            isFavoriteButtonFilled = { true }
        )
    }
}