package com.sam.weather.data.source

import com.sam.weather.data.weather.WeatherData
import com.sam.weather.data.*


interface DataSource {

    suspend fun getWeather(): Result<WeatherData>
}
