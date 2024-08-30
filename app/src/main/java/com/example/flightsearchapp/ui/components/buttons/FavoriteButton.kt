package com.example.flightsearchapp.ui.components.buttons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.flightsearchapp.R
import com.example.flightsearchapp.model.FavoriteRoute
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.fakeAirportsData

@Composable
fun FavoriteButton(
    onFavoriteRouteClicked: (FavoriteRoute) -> Unit,
    isFavoriteButtonFilled: (FavoriteRoute) -> Boolean,
    route: FavoriteRoute,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        onClick = {
            onFavoriteRouteClicked(route)
            isFavoriteButtonFilled(route)
        }
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            tint = if (isFavoriteButtonFilled(route)) Color.Red else Color.LightGray,
            contentDescription = stringResource(id = R.string.favorite)
        )
    }
}

@ThemePreviews
@Composable
fun FavoriteIconPreview() {
    FlightSearchAppTheme {
        FavoriteButton(
            onFavoriteRouteClicked = {},
            isFavoriteButtonFilled = { true },
            route = FavoriteRoute(
                id = 234,
                departureIata = fakeAirportsData.first().name,
                destinationIata = fakeAirportsData.first().iataCode
            )
        )
    }
}
