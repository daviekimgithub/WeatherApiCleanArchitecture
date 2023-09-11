package com.example.weatherapp.domain.model

data class LocationWeatherResponse(
    val current: Current,
    val location: Location
)