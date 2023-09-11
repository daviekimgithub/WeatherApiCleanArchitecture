package com.example.weatherapp.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.plugins.plugin
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json

class WeatherHttpClientImp : WeatherHttpClient {
    private val client = HttpClient {
        defaultRequest {
            url(WeatherHttpClient.BASE_URL)
            contentType(ContentType.Application.Json)
        }

        install(UserAgent) {
            agent = "Binaria"
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 60000
            socketTimeoutMillis = 60000
            connectTimeoutMillis = 6000
        }

        install(ContentNegotiation) {
            json(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(Logging) {
            logger = io.ktor.client.plugins.logging.Logger.SIMPLE
            level = io.ktor.client.plugins.logging.LogLevel.ALL
        }
    }

    override fun getHttpClient(apiKey: String, apiHost: String, location: String): HttpClient {
        client.plugin(HttpSend).intercept { request ->
            request.url.parameters.append("q", location)
            request.headers.append("X-RapidAPI-Key", apiKey)
            request.headers.append("X-RapidAPI-Host", apiHost)
            execute(request)
        }

        return client
    }
}

interface WeatherHttpClient {
    fun getHttpClient(apiKey: String, apiHost: String, location: String): HttpClient

    companion object {
        const val BASE_URL = "https://weatherapi-com.p.rapidapi.com/"
    }
}