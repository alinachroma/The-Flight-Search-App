package com.example.flightsearchapp.ui.items

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.fakeAirportsData

@Composable
fun RoutesForSelectedAirportItem(
    arrivalsForSelectedAirport: List<Airport>,
    selectedAirport: Airport,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(arrivalsForSelectedAirport) { arrival ->
            RouteItem(
                modifier = modifier,
                selectedAirport = selectedAirport,
                arrival = arrival
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
            modifier = Modifier
        )
    }
}