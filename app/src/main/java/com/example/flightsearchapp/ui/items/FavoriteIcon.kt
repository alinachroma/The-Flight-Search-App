package com.example.flightsearchapp.ui.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.flightsearchapp.R
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews

@Composable
fun FavoriteIcon(
    onFavoriteRouteClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    IconButton(
        modifier = modifier,
        onClick = { onFavoriteRouteClicked() }) {
        Icon(
            imageVector = Icons.Default.Star,
            //tint = if (isFavoriteRoute) Color.Red else Color.LightGray,
            contentDescription = stringResource(id = R.string.favorite)
        )
    }
}

@ThemePreviews
@Composable
fun FavoriteIconPreview() {
    FlightSearchAppTheme {
        FavoriteIcon(
            onFavoriteRouteClicked = {}
        )
    }
}
