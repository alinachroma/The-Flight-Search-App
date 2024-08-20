package com.example.flightsearchapp.data

import com.example.flightsearchapp.model.Airport
import kotlinx.coroutines.flow.Flow

interface AirportRepository {
    fun getAirportsStream(): Flow<List<Airport>>
}

class OfflineAirportRepository(private val airportDao: AirportDao): AirportRepository {
    override fun getAirportsStream(): Flow<List<Airport>> =
        airportDao.getAllAirports()
}