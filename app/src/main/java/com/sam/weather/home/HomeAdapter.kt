package com.sam.weather.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sam.weather.data.weather.TimeData
import com.sam.weather.databinding.ItemHomeBinding
import com.sam.weather.databinding.ItemPictureBinding

class HomeAdapter(val viewModel: HomeViewModel, private val onClickListener: OnClickListener ) : ListAdapter<TimeData, RecyclerView.ViewHolder>(DiffCallback) {

    class OnClickListener(val clickListener: (timeData: TimeData) -> Unit) {
        fun onClick(timeData: TimeData) = clickListener(timeData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_PICTURE -> PictureViewHolder(ItemPictureBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
            ITEM_VIEW_TYPE_TIME -> HomeViewHolder(ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }


    class HomeViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(time: TimeData, onClickListener: OnClickListener) {
            binding.time = time
            binding.textTemp.text = time.parameter.parameterName + time.parameter.parameterUnit
            binding.root.setOnClickListener { onClickListener.onClick(time) }
            binding.executePendingBindings()
        }
    }

    class PictureViewHolder(private val binding: ItemPictureBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.executePendingBindings()
        }
    }


    companion object DiffCallback : DiffUtil.ItemCallback<TimeData>() {
        override fun areItemsTheSame(oldItem: TimeData, newItem: TimeData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TimeData, newItem: TimeData): Boolean {
            return oldItem == newItem
        }

        private const val ITEM_VIEW_TYPE_TIME    = 0x00
        private const val ITEM_VIEW_TYPE_PICTURE = 0x01
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HomeViewHolder -> {
                holder.bind(getItem(position), onClickListener)
            }
            is PictureViewHolder -> {
                holder.bind()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position % 2) {
            1 -> ITEM_VIEW_TYPE_PICTURE
            else -> ITEM_VIEW_TYPE_TIME
        }
    }
}