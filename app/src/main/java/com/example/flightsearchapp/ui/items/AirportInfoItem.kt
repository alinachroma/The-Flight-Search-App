package com.example.flightsearchapp.ui.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.fakeAirportsData

@Composable
fun AirportInfoItem(
    airport: Airport,
    modifier: Modifier = Modifier,
    onAirportSelected: (Airport) -> Unit,
) {
    Row(modifier = modifier
        .fillMaxWidth()
        .clickable { onAirportSelected(airport) }
    ) {
        Text(text = airport.iataCode,)
        Text(text = airport.name,)
    }
}

@ThemePreviews
@Composable
fun AirportInfoItemPreview() {
    FlightSearchAppTheme {
        AirportInfoItem(
            airport = fakeAirportsData.first(),
            modifier = Modifier,
            onAirportSelected = { }
        )
    }
}