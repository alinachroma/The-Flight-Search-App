package com.example.flightsearchapp.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.fakeAirportsData

@Composable
fun AirportInfoItem(
    modifier: Modifier,
    iataCode: String,
    name: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(text = iataCode)
        Text(text = name)
    }
}

@ThemePreviews
@Composable
fun AirportInfoItemPreview() {
    FlightSearchAppTheme {
        AirportInfoItem(
            iataCode = fakeAirportsData.first().iataCode,
            name = fakeAirportsData.first().name,
            modifier = Modifier
        )
    }
}
