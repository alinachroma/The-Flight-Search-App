package com.example.flightsearchapp.data

import androidx.room.Dao
import androidx.room.Query
import com.example.flightsearchapp.model.Airport
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {

    @Query("SELECT * FROM airport WHERE name LIKE '%' || :query || '%' " +
            "OR iata_code LIKE '%' || :query || '%' " +
            "ORDER BY passengers DESC")
    fun getAirportsByQuery(query: String): Flow<List<Airport>>
}