package com.example.flightsearchapp.data

import com.example.flightsearchapp.model.FavoriteRoute
import kotlinx.coroutines.flow.Flow

interface FavoriteRouteRepository {
    fun getFavoriteRoutes(): Flow<List<FavoriteRoute>>
    suspend fun insert(favoriteRoute: FavoriteRoute)
    suspend fun delete(favoriteRoute: FavoriteRoute)
}

class OfflineFavoriteRouteRepository(private val favoriteRouteDao: FavoriteRouteDao) : FavoriteRouteRepository {

    override fun getFavoriteRoutes(): Flow<List<FavoriteRoute>> =
        favoriteRouteDao.getFavoriteRoutes()


    override suspend fun insert(favoriteRoute: FavoriteRoute) =
        favoriteRouteDao.insertFavoriteRoute(favoriteRoute)


    override suspend fun delete(favoriteRoute: FavoriteRoute) =
        favoriteRouteDao.deleteFavoriteRoute(favoriteRoute)


}