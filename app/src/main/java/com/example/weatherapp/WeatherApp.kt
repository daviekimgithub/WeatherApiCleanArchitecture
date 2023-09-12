package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.di.DataModule
import com.example.weatherapp.di.DomainModule
import com.example.weatherapp.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger()
            androidContext(this@WeatherApp)
            modules(
                DomainModule,
                DataModule,
                ViewModelModule
            )
        }
    }
}