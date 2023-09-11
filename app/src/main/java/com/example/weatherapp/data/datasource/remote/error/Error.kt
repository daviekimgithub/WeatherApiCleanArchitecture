package com.example.weatherapp.data.datasource.remote.error

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Error(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String
)