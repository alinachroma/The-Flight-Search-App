package com.example.flightsearchapp.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.model.FavoriteRoute
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.fakeAirportsData

@Composable
fun RoutesForSelectedAirportItem(
    arrivalsForSelectedAirport: List<Airport>,
    selectedAirport: Airport,
    onFavoriteRouteClicked: (FavoriteRoute) -> Unit,
    isFavoriteButtonFilled: (FavoriteRoute) -> Boolean,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(arrivalsForSelectedAirport) { destinationAirport ->
            RouteItem(
                modifier = modifier,
                selectedAirport = selectedAirport,
                destinationAirport = destinationAirport,
                onFavoriteRouteClicked = onFavoriteRouteClicked,
                isFavoriteButtonFilled = isFavoriteButtonFilled
            )
        }
    }
}

@ThemePreviews
@Composable
fun RoutesForSelectedAirportItemPreview() {
    FlightSearchAppTheme {
        RoutesForSelectedAirportItem(
            arrivalsForSelectedAirport = fakeAirportsData,
            selectedAirport = fakeAirportsData.first(),
            onFavoriteRouteClicked = {},
            isFavoriteButtonFilled = { true },
            modifier = Modifier
        )
    }
}
