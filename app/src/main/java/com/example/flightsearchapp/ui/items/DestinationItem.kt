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
fun DestinationItem(
    arrivalAirport: Airport,
    departureAirport: Airport,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Column {
                Text(text = stringResource(id = R.string.depart))
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(text = departureAirport.iataCode)
                    Text(text = departureAirport.name)
                }
                Text(text = stringResource(id = R.string.arrive))
                Row {
                    Text(text = arrivalAirport.iataCode)
                    Text(text = arrivalAirport.name)
                }
            }
        }
    }
}

@ThemePreviews
@Composable
fun DestinationItemPreview() {
    FlightSearchAppTheme {
        DestinationItem(
            arrivalAirport = fakeAirportsData.first(),
            departureAirport = fakeAirportsData.last(),
            modifier = Modifier
        )
    }
}