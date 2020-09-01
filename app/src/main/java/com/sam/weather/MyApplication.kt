package com.sam.weather

import android.app.Application
import android.content.Context
import com.sam.weather.data.source.Repository
import kotlin.properties.Delegates


class MyApplication : Application() {

    // Depends on the flavor,
    val repository: Repository
        get() = ServiceLocator.provideRepository(this)

    companion object {
        var INSTANCE: MyApplication by Delegates.notNull()
        lateinit var appContext: Context
        const val CHANNEL_ID = "exampleServiceChannel"

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        appContext = applicationContext
    }

}
