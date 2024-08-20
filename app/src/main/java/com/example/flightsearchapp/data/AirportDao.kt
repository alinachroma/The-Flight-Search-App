package com.example.flightsearchapp.data

import androidx.room.Dao
import androidx.room.Query
import com.example.flightsearchapp.model.Airport
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {

    @Query("SELECT * FROM airport")
    fun getAllAirports(): Flow<List<Airport>>
}