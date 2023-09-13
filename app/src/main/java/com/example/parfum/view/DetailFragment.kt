package com.example.parfum.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.parfum.R
import com.example.parfum.databinding.FragmentDetailBinding
import com.example.parfum.databinding.FragmentHomeBinding
import com.example.parfum.model.ListParfumePopular
import com.example.parfum.model.ParfumeDetail

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var parfumeDetail: ParfumeDetail
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
        binding.tvNameParfume.text =  parfumeDetail.parfume
        binding.tvIsi.text =  parfumeDetail.isi
        binding.tvPrice.text = parfumeDetail.price
        binding.tvDolar.text =  parfumeDetail.dolar
    }
}
