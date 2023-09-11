package com.example.weatherapp.data.datasource.remote.error

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EndpointError(
    @SerialName("message")
    val message: String
)