package com.sam.weather.data.source

import com.sam.weather.data.Result
import com.sam.weather.data.weather.WeatherData


interface Repository {
    suspend fun getWeather(): Result<WeatherData>
}
