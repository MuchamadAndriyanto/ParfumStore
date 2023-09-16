package com.example.parfum.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parfum.R
import com.example.parfum.databinding.FragmentHomeBinding
import com.example.parfum.model.ListParfumeCollection
import com.example.parfum.model.ListParfumePopular
import com.example.parfum.view.adapter.ParfumeCollectionAdapter
import com.example.parfum.view.adapter.ParfumePopularAdapter
import com.example.parfum.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupParfumeCollection()
        setupParfumePopular()

        binding.btnCart.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cartFragment)
        }

        val viewModelCart: CartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)

        //mengambil data barang yang ada di cart
        viewModelCart.getAllCartItems().observe(this, { cartItems ->
            val numItems = cartItems?.size ?: 0
            binding.btnAngka.text = numItems.toString()
        })


    }

    private fun setupParfumeCollection() {
        val listParfumeCollectionData = arrayListOf(
            ListParfumeCollection(1,R.drawable.parfume_collection_1,"parfume A ", "50ml", "Price", "48$"),
            ListParfumeCollection(2,R.drawable.parfume_collection_2,"parfume B ", "57ml", "Price", "47$"),
            ListParfumeCollection(3,R.drawable.parfume_collection_3,"parfume C ", "51ml", "Price", "46$"),
            ListParfumeCollection(4,R.drawable.parfume_collection_4,"parfume D ", "52ml", "Price", "45$"),
            ListParfumeCollection(5,R.drawable.parfume_collection_5,"parfume E ", "53ml", "Price", "44$"),
            ListParfumeCollection(6,R.drawable.parfume_collection_6,"parfume F ", "54ml", "Price", "43$"),
            ListParfumeCollection(7,R.drawable.parfume_collection_7,"parfume G ", "55ml", "Price", "42$"),
            ListParfumeCollection(8,R.drawable.parfume_collection_8,"parfume H ", "56ml", "Price", "41$")
        )

        val parfumeCollectionAdapter = ParfumeCollectionAdapter(listParfumeCollectionData)
        val lm = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvParfumeCollection.layoutManager = lm
        binding.rvParfumeCollection.adapter = parfumeCollectionAdapter
    }

    private fun setupParfumePopular() {
        val listParfumePopularData = arrayListOf(
            ListParfumePopular(1,R.drawable.parfume, "parfume I ", "51ml", "Price", "48$"),
            ListParfumePopular(2,R.drawable.parfume_collection_1, "parfume J", "53ml", "Price", "48$"),
            ListParfumePopular(3,R.drawable.parfume_collection_2, "parfume K", "54ml", "Price", "47$"),
            ListParfumePopular(4,R.drawable.parfume_collection_3, "parfume L", "57ml", "Price", "46$"),
            ListParfumePopular(5,R.drawable.parfume_collection_4, "parfume M", "53ml", "Price", "45$"),
            ListParfumePopular(6,R.drawable.parfume_collection_5, "parfume N", "59ml", "Price", "44$"),
            ListParfumePopular(7,R.drawable.parfume_collection_6, "parfume O", "58ml", "Price", "43$"),
            ListParfumePopular(8,R.drawable.parfume_collection_7, "parfume P", "51ml", "Price", "42$"),
            ListParfumePopular(9,R.drawable.parfume_collection_8, "parfume Q", "50ml", "Price", "41$")
        )

        val parfumePopularAdapter = ParfumePopularAdapter(listParfumePopularData)
        val lm2 = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvParfumePopular.layoutManager = lm2
        binding.rvParfumePopular.adapter = parfumePopularAdapter
    }
}