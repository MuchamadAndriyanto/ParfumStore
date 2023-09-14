package com.example.parfum.view

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.parfum.R
import com.example.parfum.databinding.FragmentDetailBinding
import com.example.parfum.databinding.FragmentHomeBinding
import com.example.parfum.model.ListParfumePopular
import com.example.parfum.model.ParfumeDetail
import com.example.parfum.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var parfumeDetail: ParfumeDetail
    private lateinit var viewModel: FavoriteViewModel
    private var value = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)

        binding.btnMin.setOnClickListener {
            if (value > 0) {
                value--
                binding.tvAngka.text = value.toString()
            }
        }

        binding.btnAdd.setOnClickListener {
            value++
            binding.tvAngka.text = value.toString()
        }

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        parfumeDetail = arguments?.getParcelable<ParfumeDetail>("data_parfume") as ParfumeDetail

        binding.ivParfum.setImageResource(parfumeDetail?.image ?: 0)
        binding.tvNameParfume.text = parfumeDetail.parfume
        binding.tvIsi.text = parfumeDetail.isi
        binding.tvPrice.text = parfumeDetail.price
        binding.tvDolar.text = parfumeDetail.dolar

        val favoritStatus = viewModel.isFavoriteMovie(parfumeDetail.id)
        parfumeDetail.isFavorite = favoritStatus

        binding.ivFavorite.setOnClickListener {
            parfumeDetail.isFavorite = !parfumeDetail.isFavorite
            if (parfumeDetail.isFavorite) {
                viewModel.tambahItemFavorit(parfumeDetail)
            } else {
                viewModel.deleteFavorite(parfumeDetail)
            }
            updateFavoriteButton()
        }

        updateFavoriteButton()

    }

    private fun updateFavoriteButton() {
        if (parfumeDetail.isFavorite) {
            binding.ivFavorite.setImageResource(R.drawable.baseline_favorite_24)
            binding.ivFavorite.setColorFilter(ContextCompat.getColor(requireContext(), R.color.bgbottom), PorterDuff.Mode.SRC_IN)
        } else {
            binding.ivFavorite.setImageResource(R.drawable.ic_favorite)
            binding.ivFavorite.setColorFilter(null)
        }
    }

}
