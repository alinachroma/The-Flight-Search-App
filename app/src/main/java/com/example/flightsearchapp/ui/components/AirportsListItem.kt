package com.example.flightsearchapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.flightsearchapp.R
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.fakeAirportsData

@Composable
fun AirportsListItem(
    modifier: Modifier = Modifier,
    airports: List<Airport>,
    onAirportSelected: (Airport) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
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