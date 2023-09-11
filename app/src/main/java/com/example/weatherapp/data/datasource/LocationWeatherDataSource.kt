package com.example.weatherapp.data.datasource

import com.example.weatherapp.data.datasource.remote.model.LocationsWeatherResponseData

interface LocationWeatherDataSource {
    suspend fun fetchLocationWeather() : LocationsWeatherResponseData
}