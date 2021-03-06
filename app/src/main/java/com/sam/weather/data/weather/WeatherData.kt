package com.sam.weather.data.weather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data  class WeatherData (
    val success: String? = null,
    val records: Records
): Parcelable