package com.sam.weather.data.weather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Parameter(
    val parameterName: String? = null,
    val parameterValue: String? = null
): Parcelable