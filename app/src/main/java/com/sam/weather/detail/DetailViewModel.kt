package com.sam.weather.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sam.weather.data.source.Repository
import com.sam.weather.data.weather.TimeData

class DetailViewModel(private val repository: Repository, val timeData: TimeData?) : ViewModel() {

    private val _time = MutableLiveData<TimeData>()

    val time: LiveData<TimeData>
        get() = _time

    init {

    }

    fun setTime(timeData: TimeData?){
        _time.value = timeData
    }

}
