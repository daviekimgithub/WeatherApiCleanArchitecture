package com.example.weatherapp.data.datasource.remote

import com.example.weatherapp.data.datasource.LocationWeatherDataSource
import com.example.weatherapp.data.datasource.remote.error.Error
import com.example.weatherapp.data.datasource.remote.model.LocationsWeatherResponseData
import com.example.weatherapp.network.Constants
import com.example.weatherapp.network.WeatherHttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess

class LocationWeatherDataSourceImpl (
    private val httpClient : WeatherHttpClient
) : LocationWeatherDataSource {
    override suspend fun fetchLocationWeather(): LocationsWeatherResponseData {
        val response = httpClient.getHttpClient(apiKey = Constants.key, apiHost = Constants.HOST, location = Constants.location)
            .get("/current.json")
        if (response.status.isSuccess()){
            return response.body()
        }
        val error = response.body<Error>()
        throw Exception(error.message)
    }
}