package com.example.flightsearchapp.ui.components

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.example.flightsearchapp.R
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.utils.ThemePreviews
import com.example.flightsearchapp.utils.fakeAirportsData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightSearchTopAppBar(modifier: Modifier = Modifier) {

    TopAppBar(
        title = {
            Text(
                style = MaterialTheme.typography.titleLarge,
                text = stringResource(id = R.string.app_name).uppercase(),
                modifier = modifier
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
        )
    )
}

@ThemePreviews
@Composable
fun FlightSearchTopAppBarPreview() {
    FlightSearchAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.surfaceContainerHigh
        ) {
            FlightSearchTopAppBar()
        }
    }
}