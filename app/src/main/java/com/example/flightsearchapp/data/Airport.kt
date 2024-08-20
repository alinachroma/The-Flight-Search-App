package com.example.flightsearchapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Airport(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "iata_code")
    val iataCode: String,
    val name: String,
    val passengers: Int
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$iataCode",
            "$name",
        )
        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}