package com.sam.weather.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.sam.weather.R
import com.sam.weather.databinding.FragmentDetailBinding
import com.sam.weather.ext.getVmFactory

class DetailFragment : Fragment() {

    private val viewModel by viewModels<DetailViewModel> { getVmFactory() }
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel



        return binding.root
    }

}
