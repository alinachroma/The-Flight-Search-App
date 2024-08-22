package com.example.flightsearchapp.ui.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews

@Composable
fun FavoriteIcon(
    isFavorite: Boolean,
    modifier: Modifier = Modifier
) {
    Icon(
        modifier = modifier,
        tint = when (isFavorite) {
            true -> Color.Red
            else -> {
                Color.LightGray
            }
        },
        imageVector = Icons.Filled.Star,
        contentDescription = null
    )
}

@ThemePreviews
@Composable
fun FavoriteIconPreview() {
    FlightSearchAppTheme {
        FavoriteIcon(isFavorite = false)
    }
}