package com.sam.weather.ext

import androidx.fragment.app.Fragment
import com.sam.weather.MyApplication
import com.sam.weather.ViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as MyApplication).repository
    return ViewModelFactory(repository)
}
