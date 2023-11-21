package com.example.wavesoffood.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.menuAdapter
import com.example.wavesoffood.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var  adapter:menuAdapter
    private val originalMenuFoodName = listOf("burger", "sandwich", "momo", "item", "sandwich", "momo")
    private val originalMenuItemPrice = listOf("$5", "$6", "$7", "$8", "$9", "$8")
    private val originalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ?{
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = menuAdapter(filteredMenuFoodName, filteredMenuItemPrice,filteredMenuImage)
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecyclerView.adapter =adapter

        //setup for search View
        setupSearchView()
        // show all menu items
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String?) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        originalMenuFoodName.forEachIndexed{index, foodName ->
            if (foodName.contains(query.toString(),ignoreCase = true)) {
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}