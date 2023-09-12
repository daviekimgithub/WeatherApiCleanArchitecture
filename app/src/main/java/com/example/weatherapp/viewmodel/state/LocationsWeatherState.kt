package com.example.weatherapp.viewmodel.state

data class LocationsWeatherState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val cloud: Int? = null,
    val conditionIcon: String? = null,
    val conditionText: String? = "",
    val humidity: Int = 0,
    val pressure: Double = 0.0,
    val windKPH: Double = 0.0,
    val precipitation: Double = 0.0,
    val temperature: Double = 0.0,
    val isDay: Int? = null,
    val lastUpdated: String? = null,
    val country: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val locationName: String? = null,
    val region: String? = null,
    val localTime: String? = null,
) {
}