package com.sam.weather.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sam.weather.MainViewModel
import com.sam.weather.data.source.Repository
import com.sam.weather.data.weather.TimeData
import com.sam.weather.detail.DetailViewModel
import com.sam.weather.home.HomeViewModel

@Suppress("UNCHECKED_CAST")
class TimeViewModelFactory constructor(
    private val repository: Repository,
    private val timeData: TimeData?
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(DetailViewModel::class.java) ->
                    DetailViewModel(repository, timeData)

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}
