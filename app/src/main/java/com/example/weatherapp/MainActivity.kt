package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.common.Route
import com.example.weatherapp.screen.HomeScreen
import com.example.weatherapp.screen.LocationsWeatherScreen
import com.example.weatherapp.screen.ProgressBarScreen
import com.example.weatherapp.screen.SelectWeatherLocation
import com.example.weatherapp.ui.theme.blue70
import com.example.weatherapp.viewmodel.LocationsWeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val weatherViewModel by viewModel<LocationsWeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            window.statusBarColor = blue70.toArgb()
            
            LaunchedEffect(key1 = Unit) {
                weatherViewModel.onAction(LocationsWeatherViewModel.Action.onFetchWeatherConditions)
            }

            val state = weatherViewModel.weatherStates

            if (state.isLoading) {
                ProgressBarScreen()
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                
                NavHost(
                    navController = navController,
                    startDestination = Route.Home.WeatherConditions
                ) {
                    composable(Route.Home.Home) {
                        HomeScreen(
                            navController = navController
                        )
                    }
                    composable(Route.Home.WeatherConditions) {
                        LocationsWeatherScreen(
                            viewModel = weatherViewModel,
                            navController = navController
                        )
                    }
                    composable(Route.Home.SelectLocation) {
                        SelectWeatherLocation(
                            navController = navController
                        )
                    }
                }

            }

        }
    }
}