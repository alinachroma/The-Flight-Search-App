package com.example.flightsearchapp.ui.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews

@Composable
fun FavoriteIcon(
    onFavoriteRouteClicked: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {

    IconToggleButton(
        checked = isFavoriteRoute,
        onCheckedChange = {
            isFavoriteRoute = !isFavoriteRoute
            onFavoriteRouteClicked(isFavoriteRoute)
        },
        modifier = modifier
    ) {
        Icon(
            tint = if (isFavoriteRoute) Color.Red else Color.LightGray,
            imageVector = Icons.Filled.Star,
            contentDescription = null
        )
    }
}

@ThemePreviews
@Composable
fun FavoriteIconPreview() {
    FlightSearchAppTheme {
        FavoriteIcon(
            hasFavorite = true,
            onFavoriteRouteClicked = {}
        )
    }
}