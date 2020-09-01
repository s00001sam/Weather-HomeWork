package com.sam.weather.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sam.weather.MainViewModel
import com.sam.weather.data.weather.TimeData
import com.sam.weather.databinding.FragmentHomeBinding
import com.sam.weather.ext.getVmFactory
import com.sam.weather.util.Logger

class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel> { getVmFactory() }
    lateinit var binding: FragmentHomeBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val adapter = HomeAdapter(viewModel, HomeAdapter.OnClickListener {
            viewModel.navigateToDetail(it)
        })
        binding.rcyHome.adapter = adapter

        mainViewModel.weatherResult.observe(viewLifecycleOwner, Observer {
            Logger.d("weatherResult=$it")
            it?.let {
                it.records.location[0].weatherElement.forEach {element ->
                    if (element.elementName == MINT){
                        val newList = mutableListOf<TimeData>()
                        element.time.forEachIndexed { index, timeData ->
                            val blankTime = TimeData()
                            newList.add(timeData)
                            if (index!=element.time.size-1){
                                newList.add(blankTime)
                            }
                        }
                        (binding.rcyHome.adapter as HomeAdapter).submitList(newList)
                    }
                }
            }
        })

        viewModel.navigateToDetail.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(it))
                viewModel.onDetailNavigated()
            }
        })

        return binding.root
    }


    companion object{
        private const val MINT = "MinT"
    }

}
