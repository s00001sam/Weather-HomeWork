package com.sam.weather.ext

import androidx.fragment.app.Fragment
import com.sam.weather.MyApplication
import com.sam.weather.factory.ViewModelFactory
import com.sam.weather.data.weather.TimeData
import com.sam.weather.factory.TimeViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as MyApplication).repository
    return ViewModelFactory(repository)
}

fun Fragment.getVmFactory(timeData: TimeData?): TimeViewModelFactory {
    val repository = (requireContext().applicationContext as MyApplication).repository
    return TimeViewModelFactory(repository, timeData)
}
