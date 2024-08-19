package com.example.flightsearchapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.flightsearchapp.R
import com.example.flightsearchapp.ui.items.FlightSearchTopAppBar
import com.example.flightsearchapp.ui.screens.HomeScreen

@Composable
fun FlightSearchApp(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { FlightSearchTopAppBar() },
        content = { contentPadding ->
            Surface {
                HomeScreen(
                    modifier = modifier.padding(contentPadding)
                )
            }
        }
    )
}