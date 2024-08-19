package com.example.flightsearchapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearchapp.ui.items.FlightSearchTopAppBar
import com.example.flightsearchapp.ui.screens.HomeScreen

@Composable
fun FlightSearchApp(
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<SearchViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val persons by viewModel.airports.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    Scaffold(
        topBar = { FlightSearchTopAppBar() },
        content = { contentPadding ->
            Surface {
                HomeScreen(
                    modifier = modifier.padding(contentPadding),
                    searchText = searchText,
                    airports = persons,
                    isSearching = isSearching,
                    onSearchTextChange = viewModel::onSearchTextChange
                )
            }
        }
    )
}