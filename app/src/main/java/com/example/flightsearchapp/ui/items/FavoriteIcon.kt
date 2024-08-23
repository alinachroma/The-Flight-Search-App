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
    hasFavorite: Boolean,
    onFavoriteClicked: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var isFavorite by rememberSaveable { mutableStateOf(hasFavorite) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = !isFavorite
            onFavoriteClicked(isFavorite)
        },
        modifier = modifier
    ) {
        Icon(
            tint = if (isFavorite) Color.Red else Color.LightGray,
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
            onFavoriteClicked = {}
        )
    }
}