package com.sam.weather.data.weather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class WeatherData {

    @Parcelize
    data class AnimalData (
        val success: String? = null,
        val records: Records
    ): Parcelable

}