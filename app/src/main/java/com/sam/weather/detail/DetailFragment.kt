package com.sam.weather.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import com.sam.weather.R
import com.sam.weather.databinding.FragmentDetailBinding
import com.sam.weather.ext.getVmFactory
import com.sam.weather.util.Logger

class DetailFragment : Fragment() {

    private val viewModel by viewModels<DetailViewModel> { getVmFactory(
        DetailFragmentArgs.fromBundle(requireArguments()).time
    ) }
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.setTime(DetailFragmentArgs.fromBundle(requireArguments()).time)

        viewModel.time.observe(viewLifecycleOwner, Observer {
            it?.let {
                Logger.d("timeData=$it")
                binding.textStart.text = it.startTime
                binding.textEnd.text = it.endTime
                binding.textTemp.text = it.parameter.parameterName + it.parameter.parameterUnit
            }
        })

        return binding.root
    }

}
