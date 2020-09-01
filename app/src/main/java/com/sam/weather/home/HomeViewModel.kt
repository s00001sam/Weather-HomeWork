package com.sam.weather.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

class HomeViewModel(private val repository: Repository) : ViewModel() {



}
