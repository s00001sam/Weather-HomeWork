package com.sam.weather.data.source

import com.sam.weather.data.Result
import com.sam.weather.data.weather.WeatherData


class DefaultRepository(private val remoteDataSource: DataSource,
                        private val localDataSource: DataSource
) : Repository {
    override suspend fun getWeather(): Result<WeatherData> {
        return remoteDataSource.getWeather()
    }


}
