package com.example.flightsearchapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flightsearchapp.model.FavoriteRoute
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteRouteDao {

    @Query("SELECT * FROM favorite")
    fun getFavoriteRoutes(): Flow<List<FavoriteRoute>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteRoute(favoriteRoute: FavoriteRoute)

    @Delete
    suspend fun deleteFavoriteRoute(favoriteRoute: FavoriteRoute)
}