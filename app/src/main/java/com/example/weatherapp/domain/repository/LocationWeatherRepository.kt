package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.common.Response
import com.example.weatherapp.domain.model.LocationWeatherResponse

interface LocationWeatherRepository {
    suspend fun fetchLocationWeather() : Response<LocationWeatherResponse>
}