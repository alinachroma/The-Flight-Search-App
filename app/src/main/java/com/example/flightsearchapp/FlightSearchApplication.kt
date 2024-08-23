package com.example.flightsearchapp

import android.app.Application
import com.example.flightsearchapp.data.FlightSearchDatabase
import com.example.flightsearchapp.data.OfflineAirportRepository
import com.example.flightsearchapp.data.OfflineFavoriteRouteRepository

class FlightSearchApplication: Application() {
    private val database: FlightSearchDatabase by lazy { FlightSearchDatabase.getDatabase(this) }

    val airportRepository by lazy {
        OfflineAirportRepository(database.airportDao())
    }
    val favoriteRouteRepository by lazy {
        OfflineFavoriteRouteRepository(database.favoriteRoutesDao())
    }
}