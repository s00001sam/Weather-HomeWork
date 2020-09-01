package com.sam.weather.data.source.remote

import com.sam.weather.R
import com.sam.weather.data.Result
import com.sam.weather.data.source.DataSource
import com.sam.weather.data.weather.WeatherData
import com.sam.weather.data.*
import com.sam.weather.network.MyApi
import com.sam.weather.util.Logger
import com.sam.weather.util.Util.getString
import com.sam.weather.util.Util.isInternetConnected

object RemoteDataSource : DataSource {

    override suspend fun getWeather(): Result<WeatherData> {
        if (!isInternetConnected()) {
            return Result.Fail(getString(R.string.internet_not_connected))
        }

        return try {
            // this will run on a thread managed by Retrofit
            val result = MyApi.retrofitService.getWeather()

            Result.Success(result)

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }


}

