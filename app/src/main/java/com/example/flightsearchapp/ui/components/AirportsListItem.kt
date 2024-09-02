package com.example.flightsearchapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.flightsearchapp.model.Airport

@Composable
fun AirportsListItem(
    modifier: Modifier = Modifier,
    airports: List<Airport>,
    onAirportSelected: (Airport) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth()
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

@ThemePreviews
@Composable
fun AirportsListItemPreview() {
    FlightSearchAppTheme {
        AirportsListItem(
            airports = fakeAirportsData,
            onAirportSelected = {})
    }
}