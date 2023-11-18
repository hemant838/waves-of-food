package com.example.wavesoffood.Popularadapter

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.CartItemBinding

class cartAdapter(private val CartItems:MutableList<String>, private val CartItemPrice: MutableList<String>, private var CartImage : MutableList<Int>) : RecyclerView.Adapter<cartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(CartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        var binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return CartItems.size
    }

    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int)
        {
            val quatities = itemQuantities
            binding.apply {
                cartFoodName.text = CartItems[position]
                cartItemPrice.text = CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                quantity.text = quantity.toString()

                minusButton.setOnClickListener {
                    decreaseQuantity(position)
                }

                plusButton.setOnClickListener {
                    increaseQuantity(position)
                }

                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION)
                    {
                        deleteitem(itemPosition)
                    }

                }
            }
        }
        private fun deleteitem(position: Int)
        {
            CartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, CartItems.size)
        }

        private fun increaseQuantity(position: Int)
        {
            if(itemQuantities[position] < 10)
            {
                itemQuantities[position]++
                binding.quantity.text = itemQuantities[position].toString()
            }
        }

        private fun decreaseQuantity(position: Int)
        {
            if(itemQuantities[position] > 1)
            {
                itemQuantities[position]--
                binding.quantity.text = itemQuantities[position].toString()
            }
        }
    }
}