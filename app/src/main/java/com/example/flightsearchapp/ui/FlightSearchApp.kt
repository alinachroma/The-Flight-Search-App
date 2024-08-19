package com.example.flightsearchapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import com.example.flightsearchapp.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.flightsearchapp.ui.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightSearchApp(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { R.string.app_name }) },
        content = { contentPadding ->
            Surface(
            ) {
            }
        }
    )
}