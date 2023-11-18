package com.example.wavesoffood.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.Popularadapter.cartAdapter
import com.example.wavesoffood.R
import com.example.wavesoffood.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFood = listOf("burger", "sandwich", "momo", "item", "sandwich", "momo")
        val cartItemPrice = listOf("$5", "$6", "$7", "$8", "$9", "$8")
        val cartImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6
        )
        val adapter =
            cartAdapter(ArrayList(cartFood), ArrayList(cartItemPrice), ArrayList(cartImage))
        binding.cartReyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartReyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}