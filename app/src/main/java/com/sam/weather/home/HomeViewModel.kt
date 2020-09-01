package com.sam.weather.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sam.weather.Control
import com.sam.weather.MyApplication
import com.sam.weather.R
import com.sam.weather.data.source.Repository
import com.sam.weather.data.weather.WeatherData
import com.sam.weather.network.LoadApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import com.sam.weather.data.*
import com.sam.weather.data.weather.TimeData
import com.sam.weather.data.weather.WeatherElement

class HomeViewModel(private val repository: Repository) : ViewModel() {

    // Handle navigation to detail
    private val _navigateToDetail = MutableLiveData<TimeData>()

    val navigateToDetail: LiveData<TimeData>
        get() = _navigateToDetail

    init {
        setFirstTime()
    }

    fun setFirstTime(){
        if (Control.isFirstTime == true){
            Control.isFirstTime = false
        }
    }

    fun navigateToDetail(time: TimeData) {
        _navigateToDetail.value = time
    }

    fun onDetailNavigated() {
        _navigateToDetail.value = null
    }

    fun makeFakeTimes(element: WeatherElement): MutableList<TimeData> {
        val newList = mutableListOf<TimeData>()
        element.time.forEachIndexed { index, timeData ->
            val blankTime = TimeData()
            newList.add(timeData)
            if (index != element.time.size - 1) {
                newList.add(blankTime)
            }
        }
        return newList
    }

}
