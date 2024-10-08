package com.example.flightsearchapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.flightsearchapp.R
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.model.FavoriteRoute
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.fakeAirportsData

@Composable
fun FavoriteRoutesItem(
    modifier: Modifier = Modifier,
    favorites: List<FavoriteRoute>,
    airports: List<Airport>,
    onFavoriteRouteClicked: (FavoriteRoute) -> Unit,
    isFavoriteButtonFilled: (FavoriteRoute) -> Boolean,
) {
    LazyColumn(
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        items(
            items = favorites,
            key = { it.id }
        ) { favoriteRoute ->
            airports.find {
                it.iataCode == favoriteRoute.departureIata
            }?.let { airport ->
                airports.find { it.iataCode == favoriteRoute.destinationIata }?.name
                    ?.let {
                        RouteItem(
                            departureIata = favoriteRoute.departureIata,
                            destinationIata = favoriteRoute.destinationIata,
                            departureName = airport.name,
                            destinationName = it,
                            onFavoriteRouteClicked = onFavoriteRouteClicked,
                            isFavoriteButtonFilled = isFavoriteButtonFilled,
                            modifier = Modifier.animateItem()
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
        Surface(
            color = MaterialTheme.colorScheme.surfaceContainerHigh
        ) {
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
}