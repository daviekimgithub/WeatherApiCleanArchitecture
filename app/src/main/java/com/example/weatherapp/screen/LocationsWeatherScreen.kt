package com.example.weatherapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherapp.R
import com.example.weatherapp.common.WeatherCard
import com.example.weatherapp.common.WeatherCardDataClass
import com.example.weatherapp.viewmodel.LocationsWeatherViewModel

@Composable
fun LocationsWeatherScreen(
    viewModel: LocationsWeatherViewModel,
    navController: NavController
) {
    val state = viewModel.weatherStates
    val scope = rememberCoroutineScope()
    var dayOrNight: String = if (state.isDay == 1) "day" else "night"
    var dayOrNightImg: Int = if (state.isDay == 1) R.drawable.day_mode else R.drawable.night
    val weatherConditions = arrayOf(
        WeatherCardDataClass(
            image = if (state.isDay == 1) R.drawable.day_mode else R.drawable.night,
            text = if (state.isDay == 1) "day" else "night",
            description = "time"
        ),
        WeatherCardDataClass(
            image = R.drawable.cloudy,
            text = if (state.isDay == 1) "Cloudy" else "Clear",
            description = "cloudy"
        ),
        WeatherCardDataClass(
            image = R.drawable.humidity,
            text = state.humidity.toString(),
            description = "humidity"
        ),
        WeatherCardDataClass(
            image = R.drawable.precipitation,
            text = state.precipitation.toString(),
            description = "precipitation"
        ),
        WeatherCardDataClass(
            image = R.drawable.pressure_gauge,
            text = state.pressure.toString(),
            description = "pressure"
        ),
        WeatherCardDataClass(
            image = R.drawable.temperature,
            text = state.temperature.toString(),
            description = "temperature"
        ),
        WeatherCardDataClass(
            image = R.drawable.wind,
            text = state.windKPH.toString(),
            description = "wind speed"
        ),
        )


    Column(
        modifier = Modifier.padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = painterResource(id = R.drawable.weather_light),
            contentDescription = "Weather Background"
        )
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(weatherConditions.size) { each ->
                WeatherCard(weatherConditions[each])
            }
        }
    }

}