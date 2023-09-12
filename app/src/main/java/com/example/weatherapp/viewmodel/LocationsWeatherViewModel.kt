package com.example.weatherapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.usecase.FetchExchangeRatesUseCase
import com.example.weatherapp.viewmodel.state.LocationsWeatherState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationsWeatherViewModel (
    private val fetchLocationsWeatherUseCase: FetchExchangeRatesUseCase
): ViewModel() {
    var weatherStates by mutableStateOf(LocationsWeatherState())

    fun onAction(action: Action){
        when(action){
            is Action.onFetchWeatherConditions -> {
                fetchWeatherConditions()
            }
            is Action.onLocationSelectedState -> {
                if (!action.latitude.isNaN() && !action.longitude.isNaN() ){
                    fetchWeatherConditions()
                }
            }
        }
    }

    fun fetchWeatherConditions() {
        weatherStates = weatherStates.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            fetchLocationsWeatherUseCase.execute()
                .fold(
                    onSuccess ={
                        val location = it.location
                        val current = it.current
                        weatherStates = weatherStates.copy(
                            cloud = current.cloud,
                            conditionIcon = current.condition.icon,
                            conditionText = current.condition.text,
                            humidity =  current.humidity,
                            pressure = current.pressure_mb,
                            windKPH = current.wind_kph,
                            precipitation = current.precip_mm,
                            temperature = current.temp_c,
                            isDay = current.is_day,
                            lastUpdated = current.last_updated,
                            country = location.country,
                            latitude = location.lat,
                            longitude = location.lon,
                            locationName = location.name,
                            region = location.region,
                            localTime = location.localtime
                        )
                    },
                    onFailure = {
                        weatherStates = weatherStates.copy(
                            error = it.message,
                            isLoading = false
                        )
                    }
                )
        }
    }


    sealed interface Action {
        object onFetchWeatherConditions: Action
        data class onLocationSelectedState(val latitude: Double, val longitude: Double): Action

    }
}