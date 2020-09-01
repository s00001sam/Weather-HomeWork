package com.sam.weather.data.weather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TimeData(
    val startTime: String? = null,
    val endTime: String? = null,
    val parameter: Parameter
):Parcelable