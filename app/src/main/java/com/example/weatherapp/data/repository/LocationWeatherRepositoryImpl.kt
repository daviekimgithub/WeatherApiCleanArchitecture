package com.example.weatherapp.data.repository

import com.example.weatherapp.data.datasource.LocationWeatherDataSource
import com.example.weatherapp.data.datasource.remote.model.toDomain
import com.example.weatherapp.domain.common.Response
import com.example.weatherapp.domain.model.LocationWeatherResponse
import com.example.weatherapp.domain.repository.LocationWeatherRepository

class LocationWeatherRepositoryImpl (
    private val dataSource: LocationWeatherDataSource
) : LocationWeatherRepository {
    override suspend fun fetchLocationWeather(): Response<LocationWeatherResponse> {
        return try {
            Response.success(dataSource.fetchLocationWeather().toDomain())
        } catch (e: Exception) {
            Response.failure(e)
        }
    }
}