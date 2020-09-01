package com.sam.weather.data.source.local

import android.content.Context
import com.sam.weather.data.Result
import com.sam.weather.data.source.DataSource
import com.sam.weather.data.weather.WeatherData

class LocalDataSource(val context: Context) :
    DataSource {
    override suspend fun getWeather(): Result<WeatherData> {
        TODO("Not yet implemented")
    }


}
