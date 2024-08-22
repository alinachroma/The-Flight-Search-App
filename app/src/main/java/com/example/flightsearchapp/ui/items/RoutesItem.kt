package com.example.flightsearchapp.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.flightsearchapp.R
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.fakeAirportsData

@Composable
fun RouteItem(
    modifier: Modifier = Modifier,
    selectedAirport: Airport,
    arrival: Airport
) {
    Card(
        modifier = modifier,
    ) {
        Row(modifier = modifier.padding(8.dp)) {
            Column {
                Text(text = stringResource(id = R.string.depart))
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(text = selectedAirport.iataCode)
                    Text(text = selectedAirport.name)
                }
                Text(text = stringResource(id = R.string.arrive))
                Row {
                    Text(text = arrival.iataCode)
                    Text(text = arrival.name)
                }
            }
        }
    }
}

@ThemePreviews
@Composable
fun RouteItemPreview() {
    FlightSearchAppTheme {
        RouteItem(
            selectedAirport = fakeAirportsData.first(),
            arrival = fakeAirportsData.last())
    }
}