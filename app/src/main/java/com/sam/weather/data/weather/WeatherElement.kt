package com.sam.weather.data.weather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherElement (
    val elementName: String? = null,
    val time: List<TimeData>
): Parcelable