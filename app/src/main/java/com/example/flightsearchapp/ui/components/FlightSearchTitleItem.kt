package com.example.flightsearchapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.flightsearchapp.R
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.fakeAirportsData

@Composable
fun FlightSearchTitleItem(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier
            .padding(
                start = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_small),
                bottom = dimensionResource(id = R.dimen.padding_small)
            ),
        text = text,
        style = MaterialTheme.typography.displaySmall,
    )
}

@ThemePreviews
@Composable
fun FlightSearchTitleItemPreview() {
    FlightSearchAppTheme {
        FlightSearchTitleItem(
            text = stringResource(
                id = R.string.flights_from, fakeAirportsData.first().iataCode
            )
        )
    }
}