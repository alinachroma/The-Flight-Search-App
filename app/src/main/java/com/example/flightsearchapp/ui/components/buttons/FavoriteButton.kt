package com.example.flightsearchapp.ui.components.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.flightsearchapp.R
import com.example.flightsearchapp.model.FavoriteRoute
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.ui.theme.starIconGradient
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.brush
import com.example.flightsearchapp.utils.fakeAirportsData
import com.example.flightsearchapp.utils.starIconRippleConfiguration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteButton(
    onFavoriteRouteClicked: (FavoriteRoute) -> Unit,
    isFavoriteButtonFilled: (FavoriteRoute) -> Boolean,
    route: FavoriteRoute,
    modifier: Modifier = Modifier
) {

    CompositionLocalProvider(LocalRippleConfiguration provides starIconRippleConfiguration) {
        IconButton(
            modifier = modifier,
            onClick = {
                onFavoriteRouteClicked(route)
                isFavoriteButtonFilled(route)
            }
        ) {
            Icon(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.icon_standard))
                    .let {
                        if (isFavoriteButtonFilled(route)) {
                            return@let it
                                .graphicsLayer(alpha = 0.99f)
                                .drawWithCache {
                                    onDrawWithContent {
                                        drawContent()
                                        drawRect(
                                            brush = brush,
                                            blendMode = BlendMode.SrcAtop
                                        )
                                    }
                                }
                        }
                        it
                    },
                imageVector = Icons.Default.Star,
                tint = Color.LightGray,
                contentDescription = stringResource(id = R.string.favorite)
            )
        }
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
