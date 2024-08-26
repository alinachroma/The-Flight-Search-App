package com.example.flightsearchapp.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.flightsearchapp.R
import com.example.flightsearchapp.model.Airport
import com.example.flightsearchapp.model.FavoriteRoute
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.fakeAirportsData

@Composable
fun RouteItem(
    modifier: Modifier = Modifier,
    selectedAirport: Airport,
    onFavoriteRouteClicked: (FavoriteRoute) -> Unit,
    destinationAirport: Airport
) {
    Card(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Text(text = stringResource(id = R.string.depart))
                AirportInfoItem(
                    modifier = Modifier,
                    airport = selectedAirport
                )
                Text(text = stringResource(id = R.string.arrive))
                AirportInfoItem(
                    modifier = Modifier,
                    airport = destinationAirport
                )
            }
            FavoriteIcon(
                modifier = Modifier,
                onFavoriteRouteClicked = {
                    onFavoriteRouteClicked(
                        FavoriteRoute(
                            departureIata = selectedAirport.iataCode,
                            destinationIata = destinationAirport.iataCode
                        )
                    )                }
            )
        }
    }
}

@ThemePreviews
@Composable
fun RouteItemPreview() {
    FlightSearchAppTheme {
        RouteItem(
            selectedAirport = fakeAirportsData.first(),
            destinationAirport = fakeAirportsData.last(),
            onFavoriteRouteClicked = {}
        )
    }