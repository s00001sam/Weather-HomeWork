package com.sam.weather.data.source


class DefaultRepository(private val remoteDataSource: DataSource,
                        private val localDataSource: DataSource
) : Repository {


}
