package com.example.weatherapp.data.datasource.remote.model

import com.example.weatherapp.domain.model.Condition
import com.example.weatherapp.domain.model.Current
import com.example.weatherapp.domain.model.Location
import com.example.weatherapp.domain.model.LocationWeatherResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationsWeatherResponseData(
    @SerialName("current")
    val current: CurrentResponseData,
    @SerialName("location")
    val location: LocationResponseData
)

fun LocationsWeatherResponseData.toDomain() = LocationWeatherResponse (
    current = Current(
        cloud = current.cloud,
        condition = Condition(
            code = current.condition.code,
            icon = current.condition.icon,
            text = current.condition.text
        ),
        feelslike_c = current.feelslike_c,
        feelslike_f = current.feelslike_f,
        gust_kph = current.gust_kph,
        gust_mph = current.gust_mph,
        humidity = current.humidity,
        is_day = current.is_day,
        last_updated = current.last_updated,
        last_updated_epoch = current.last_updated_epoch,
        precip_in = current.precip_in,
        precip_mm = current.precip_mm,
        pressure_in = current.pressure_in,
        pressure_mb = current.pressure_mb,
        temp_c = current.temp_c,
        temp_f = current.temp_f,
        uv = current.uv,
        vis_km = current.vis_km,
        vis_miles = current.vis_miles,
        wind_degree = current.wind_degree,
        wind_dir = current.wind_dir,
        wind_kph = current.wind_kph,
        wind_mph = current.wind_mph
    ),
    location = Location (
        country = location.country,
        lat = location.lat,
        localtime = location.localtime,
        localtime_epoch = location.localtime_epoch,
        lon = location.lon,
        name = location.name,
        region = location.region,
        tz_id = location.tz_id
    )
)
