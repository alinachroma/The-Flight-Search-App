package com.example.flightsearchapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsearchapp.data.Airport
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class SearchViewModel : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _airports = MutableStateFlow(allAirports)

    @OptIn(FlowPreview::class)
    val airports = searchText
        .debounce(500L)
        .onEach { _isSearching.update { true } }
        .combine(_airports) { text, persons ->
            if (text.isBlank()) {
                persons
            } else {
                delay(2000L)
                persons.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }.onEach { _isSearching.update { false } }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = _airports.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}

private val allAirports = listOf(
    Airport(id = 9565, iataCode = "VIE", name = "Vienna International Airport", passengers = 2006),
    Airport(id = 3886, iataCode = "MUC", name = "Munich International Airport", passengers = 3729),
    Airport(id = 5816, iataCode = "DUS", name = "Duesseldorf International Airport", passengers = 55),
    Airport(id = 5199, iataCode = "KEF", name = "Keflavik International Airport", passengers = 3927)
)