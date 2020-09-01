package com.sam.weather.data.weather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Parameter(
    val parameterName: String? = null,
    val parameterUnit: String? = null
): Parcelable