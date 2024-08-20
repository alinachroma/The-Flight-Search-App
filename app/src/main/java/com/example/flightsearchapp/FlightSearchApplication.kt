package com.example.flightsearchapp

import android.app.Application
import com.example.flightsearchapp.data.FlightSearchDatabase
import com.example.flightsearchapp.data.FlightSearchAirportRepository

class FlightSearchApplication: Application() {
    private val database: FlightSearchDatabase by lazy { FlightSearchDatabase.getDatabase(this) }
    val airportRepository by lazy {
        FlightSearchAirportRepository(database.airportDao())
    }
}