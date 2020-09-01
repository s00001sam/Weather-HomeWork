package com.sam.weather.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sam.weather.MyApplication
import com.sam.weather.R
import com.sam.weather.data.weather.WeatherData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val API_URL = "https://opendata.cwb.gov.tw/api/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(API_URL)
    .client(client)
    .build()


//function of call Api
interface ApiServices {

    @GET("rest/datastore/F-C0032-001")
    suspend fun getWeather(
        @Query("Authorization") key: String = MyApplication.INSTANCE.getString(R.string.weather_key),
        @Query("format") format: String = "JSON",
        @Query("locationName") locationName: String = "臺北市"
    ): WeatherData

}

object MyApi {
    val retrofitService by lazy { retrofit.create(
        ApiServices::class.java) }
}