package com.example.parfum.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parfum.databinding.FragmentCartBinding
import com.example.parfum.view.adapter.ParfumeCartAdapter
import com.example.parfum.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvParfumeCart.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvParfumeCart.setHasFixedSize(false)

        viewModel.getAllCartItems().observe(viewLifecycleOwner) { cartItems ->
            val adapter = ParfumeCartAdapter(cartItems) { item ->
                viewLifecycleOwner.lifecycleScope.launch {
                    viewModel.deleteCartItem(item.id)
                }
            }

            binding.rvParfumeCart.adapter = adapter
        }
    }
}