package com.example.weatherapp.domain.usecase

import com.example.weatherapp.domain.InternetService
import com.example.weatherapp.domain.common.Response
import com.example.weatherapp.domain.common.exception.InternetException
import com.example.weatherapp.domain.common.usecase.UseCaseNoInput
import com.example.weatherapp.domain.model.LocationWeatherResponse
import com.example.weatherapp.domain.repository.LocationWeatherRepository

class FetchExchangeRatesUseCase(
    private val internetService: InternetService,
    private val locationWeatherRepository: LocationWeatherRepository
): UseCaseNoInput<LocationWeatherResponse> {
    override suspend fun execute(): Response<LocationWeatherResponse> {
        if (!internetService.isConnected()) {
            return Response.failure(InternetException)
        }
        return locationWeatherRepository.fetchLocationWeather()
    }
}