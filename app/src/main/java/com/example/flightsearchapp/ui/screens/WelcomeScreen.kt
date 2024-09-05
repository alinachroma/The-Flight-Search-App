package com.example.flightsearchapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.flightsearchapp.R
import com.example.flightsearchapp.ui.components.buttons.ArrowUpwardIcon
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_large)),
        verticalArrangement = Arrangement.spacedBy(
            space = dimensionResource(id = R.dimen.padding_medium),
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArrowUpwardIcon()
        Text(
            text = stringResource(id = R.string.welcome),
            color = MaterialTheme.colorScheme.inverseSurface,
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = stringResource(id = R.string.lets_search),
            color = MaterialTheme.colorScheme.inverseSurface,
            style = MaterialTheme.typography.displayLarge
        )
    }

}

@ThemePreviews
@Composable
fun WelcomeScreenPreview() {
    FlightSearchAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.surfaceContainerHigh
        ) {
            WelcomeScreen()
        }
    }
}