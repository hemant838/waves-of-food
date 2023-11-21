package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.PopularItemBinding

class popularAdapter (private val items:List<String>, private val price:List<String>,private val image:List<Int>): RecyclerView.Adapter<popularAdapter.popularViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): popularAdapter.popularViewHolder {
        return popularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: popularAdapter.popularViewHolder, position: Int) {
        val item = items[position]
        val price = price[position]
        val images = image[position]
        holder.bind(item,price,images)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class popularViewHolder (private var binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val imagesView = binding.imageView6
        fun bind(item: String,price: String ,images: Int) {
        binding.foodnamepopular.text = item
        binding.pricePopular.text = price
        imagesView.setImageResource(images)
        }

    }
}