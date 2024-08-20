package com.example.flightsearchapp.data

import com.example.flightsearchapp.model.Airport
import kotlinx.coroutines.flow.Flow

interface AirportRepository {
    fun getAirportByQuery(query: String): Flow<List<Airport>>
}

class FlightSearchAirportRepository(private val airportDao: AirportDao): AirportRepository {
    override fun getAirportByQuery(query: String): Flow<List<Airport>> =
        airportDao.getAirportQuery(query)
}