package com.example.flightsearchapp.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.flightsearchapp.R
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews

@Composable
fun DestinationItem(
    departureName: String,
    arrivalName: String,
    iataCodeDeparture: String,
    iataCodeArrival: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Column {
                Text(text = stringResource(id = R.string.depart))
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(text = iataCodeDeparture)
                    Text(text = departureName)
                }
                Text(text = stringResource(id = R.string.arrive))
                Row {
                    Text(text = iataCodeArrival)
                    Text(text = arrivalName)
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
            departureName = "Leonardo da Vinci International Airport",
            arrivalName = "Munich International Airport",
            iataCodeDeparture = "FCO",
            iataCodeArrival = "MUC",
            modifier = Modifier
        )
    }
}