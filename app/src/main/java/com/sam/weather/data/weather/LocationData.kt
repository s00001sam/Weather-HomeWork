package com.sam.weather.data.weather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationData(
    val locationName: String? = null,
    val weatherElement: List<WeatherElement>
): Parcelable