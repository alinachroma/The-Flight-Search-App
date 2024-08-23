package com.example.flightsearchapp.data

import com.example.flightsearchapp.model.FavoriteRoute
import kotlinx.coroutines.flow.Flow

interface FavoriteRouteRepository {
    fun getFavoriteRoutes(): Flow<List<FavoriteRoute>>
    suspend fun insertFavoriteRoute(favoriteRoute: FavoriteRoute)
    suspend fun deleteFavoriteRoute(favoriteRoute: FavoriteRoute)
}

class OfflineFavoriteRouteRepository(private val favoriteRouteDao: FavoriteRouteDao) : FavoriteRouteRepository {

    override fun getFavoriteRoutes(): Flow<List<FavoriteRoute>> =
        favoriteRouteDao.getFavoriteRoutes()


    override suspend fun insertFavoriteRoute(favoriteRoute: FavoriteRoute) =
        favoriteRouteDao.insertFavoriteRoute(favoriteRoute)


    override suspend fun deleteFavoriteRoute(favoriteRoute: FavoriteRoute) =
        favoriteRouteDao.deleteFavoriteRoute(favoriteRoute)


}