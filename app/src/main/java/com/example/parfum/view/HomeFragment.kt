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
            ListParfumeCollection(R.drawable.parfume_collection_1),
            ListParfumeCollection(R.drawable.parfume_collection_2),
            ListParfumeCollection(R.drawable.parfume_collection_3),
            ListParfumeCollection(R.drawable.parfume_collection_4),
            ListParfumeCollection(R.drawable.parfume_collection_5),
            ListParfumeCollection(R.drawable.parfume_collection_6),
            ListParfumeCollection(R.drawable.parfume_collection_7),
            ListParfumeCollection(R.drawable.parfume_collection_8)
        )

        val parfumeCollectionAdapter = ParfumeCollectionAdapter(listParfumeCollectionData)
        val lm = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvParfumeCollection.layoutManager = lm
        binding.rvParfumeCollection.adapter = parfumeCollectionAdapter
    }

    private fun setupParfumePopular() {
        val listParfumePopularData = arrayListOf(
            ListParfumePopular(R.drawable.parfume, "parfume Chanel ", "50ml", "Price", "48$"),
            ListParfumePopular(R.drawable.parfume_collection_1, "parfume Dior", "50ml", "Price", "48$"),
            ListParfumePopular(R.drawable.parfume_collection_2, "parfume Gucci", "50ml", "Price", "47$"),
            ListParfumePopular(R.drawable.parfume_collection_3, "parfume Yves", "50ml", "Price", "46$"),
            ListParfumePopular(R.drawable.parfume_collection_4, "parfume Versace", "50ml", "Price", "45$"),
            ListParfumePopular(R.drawable.parfume_collection_5, "parfume Dolce ", "50ml", "Price", "44$"),
            ListParfumePopular(R.drawable.parfume_collection_6, "parfume Marc", "50ml", "Price", "43$"),
            ListParfumePopular(R.drawable.parfume_collection_7, "parfume Calvin", "50ml", "Price", "42$"),
            ListParfumePopular(R.drawable.parfume_collection_8, "parfume Malone", "50ml", "Price", "41$")

        )

        val parfumePopularAdapter = ParfumePopularAdapter(listParfumePopularData)
        val lm2 = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvParfumePopular.layoutManager = lm2
        binding.rvParfumePopular.adapter = parfumePopularAdapter
    }
}