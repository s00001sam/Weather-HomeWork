package com.sam.weather.util

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.sam.weather.data.source.DataSource
import com.sam.weather.data.source.DefaultRepository
import com.sam.weather.data.source.Repository
import com.sam.weather.data.source.local.LocalDataSource
import com.sam.weather.data.source.remote.RemoteDataSource

object ServiceLocator {

    @Volatile
    var repository: Repository? = null
        @VisibleForTesting set

    fun provideRepository(context: Context): Repository {
        synchronized(this) {
            return repository
                ?: repository
                ?: createPublisherRepository(context)
        }
    }

    private fun createPublisherRepository(context: Context): Repository {
        return DefaultRepository(
            RemoteDataSource,
            createLocalDataSource(context)
        )
    }

    private fun createLocalDataSource(context: Context): DataSource {
        return LocalDataSource(context)
    }
}