package com.sam.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.sam.gogozoo.ext.getVmFactory
import com.sam.weather.databinding.ActivityMainBinding
import com.sam.weather.util.Logger

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<MainViewModel> { getVmFactory() }
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        //Navigation NavController
        navController = Navigation.findNavController(this, R.id.myNavHostFragment)

    }
}
