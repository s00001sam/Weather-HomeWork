package com.sam.weather.data.weather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Records (
    val datasetDescription: String? = null,
    val location: List<LocationData>
): Parcelable
