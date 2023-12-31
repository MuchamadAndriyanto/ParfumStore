package com.example.parfum.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parfum.R
import com.example.parfum.databinding.FragmentFavoriteBinding
import com.example.parfum.view.adapter.FavoriteParfumAdapter
import com.example.parfum.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding : FragmentFavoriteBinding
    private lateinit var viewModel: FavoriteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
        itemFavorit()

    }

    private fun itemFavorit() {
        binding.rvParfumeFavorite.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvParfumeFavorite.setHasFixedSize(false)
        viewModel.getAllFavorite()
        viewModel.getAllFavorite().observe(viewLifecycleOwner) {
            if (it != null) {
                binding.rvParfumeFavorite.adapter = FavoriteParfumAdapter(it)
            }
        }
    }

}