package com.example.weatherapp.di

import com.example.weatherapp.data.datasource.LocationWeatherDataSource
import com.example.weatherapp.data.datasource.remote.LocationWeatherDataSourceImpl
import com.example.weatherapp.data.repository.LocationWeatherRepositoryImpl
import com.example.weatherapp.domain.InternetService
import com.example.weatherapp.domain.InternetServiceImpl
import com.example.weatherapp.domain.repository.LocationWeatherRepository
import com.example.weatherapp.domain.usecase.FetchExchangeRatesUseCase
import com.example.weatherapp.network.WeatherHttpClient
import com.example.weatherapp.network.WeatherHttpClientImp
import com.example.weatherapp.viewmodel.LocationsWeatherViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DomainModule = module {
    factory { FetchExchangeRatesUseCase(get(), get()) }
}

val DataModule = module {
    factory<WeatherHttpClient> { WeatherHttpClientImp() }
    single<InternetService> { InternetServiceImpl(androidContext()) }
    single<LocationWeatherRepository> { LocationWeatherRepositoryImpl(get()) }
    single<LocationWeatherDataSource>{ LocationWeatherDataSourceImpl(get()) }
}

val ViewModelModule = module {
    viewModel { LocationsWeatherViewModel(get()) }
}