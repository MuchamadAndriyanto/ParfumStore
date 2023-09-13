package com.example.parfum.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parfum.R
import com.example.parfum.databinding.FragmentHomeBinding
import com.example.parfum.model.ListParfumeCollection
import com.example.parfum.model.ListParfumePopular
import com.example.parfum.view.adapter.ParfumeCollectionAdapter
import com.example.parfum.view.adapter.ParfumePopularAdapter

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupParfumeCollection()
        setupParfumePopular()
    }

    private fun setupParfumeCollection() {
        val listParfumeCollectionData = arrayListOf(
            ListParfumeCollection(R.drawable.parfume_collection),
            ListParfumeCollection(R.drawable.parfume_collection_2),
            ListParfumeCollection(R.drawable.parfume_collection_3),
            ListParfumeCollection(R.drawable.parfume_collection),
            ListParfumeCollection(R.drawable.parfume_collection)
        )

        val parfumeCollectionAdapter = ParfumeCollectionAdapter(listParfumeCollectionData)
        val lm = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvParfumeCollection.layoutManager = lm
        binding.rvParfumeCollection.adapter = parfumeCollectionAdapter
    }

    private fun setupParfumePopular() {
        val listParfumePopularData = arrayListOf(
            ListParfumePopular(R.drawable.parfume, "parfume", "50ml", "price", "48$"),
            ListParfumePopular(R.drawable.parfume, "parfume", "50ml", "price", "48$"),
            ListParfumePopular(R.drawable.parfume, "parfume", "50ml", "price", "48$"),
            ListParfumePopular(R.drawable.parfume, "parfume", "50ml", "price", "48$")
        )

        val parfumePopularAdapter = ParfumePopularAdapter(listParfumePopularData)
        val lm2 = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvParfumePopular.layoutManager = lm2
        binding.rvParfumePopular.adapter = parfumePopularAdapter
    }
}