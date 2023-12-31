package com.example.parfum.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvParfumeCart.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvParfumeCart.setHasFixedSize(false)

        viewModel.getAllCartItems().observe(viewLifecycleOwner) { cartItems ->
            val adapter = ParfumeCartAdapter(cartItems) { item ->
                val alertDialogBuilder = AlertDialog.Builder(requireContext())
                alertDialogBuilder.setMessage("Apakah Anda ingin menghapus barang ini?")
                alertDialogBuilder.setPositiveButton("Ya") { _, _ ->
                    // Jika pengguna menekan tombol "Ya", maka hapus item
                    viewLifecycleOwner.lifecycleScope.launch {
                        viewModel.deleteCartItem(item.id)
                    }
                }
                alertDialogBuilder.setNegativeButton("Tidak") { dialog, _ ->
                    // Jika pengguna menekan tombol "Tidak", tutup dialog tanpa menghapus item
                    dialog.dismiss()
                }

                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }

            binding.rvParfumeCart.adapter = adapter

//            val itemTouchHelperCallback = object :
//                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
//                override fun onMove(
//                    recyclerView: RecyclerView,
//                    viewHolder: RecyclerView.ViewHolder,
//                    target: RecyclerView.ViewHolder
//                ): Boolean {
//                    // Implementasi ini tidak diperlukan jika Anda tidak ingin mendukung drag-and-drop
//                    return false
//                }
//
//                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                    val position = viewHolder.adapterPosition
//                    val item = adapter.getCartPosition(position)
//
//                    val alertDialogBuilder = AlertDialog.Builder(requireContext())
//                    alertDialogBuilder.setMessage("Apakah Anda ingin menghapus barang ini?")
//                    alertDialogBuilder.setPositiveButton("Ya") { _, _ ->
//                        // Jika pengguna menekan tombol "Ya", maka hapus item
//                        viewLifecycleOwner.lifecycleScope.launch {
//                            viewModel.deleteCartItem(item.id)
//                        }
//                    }
//                    alertDialogBuilder.setNegativeButton("Tidak") { dialog, _ ->
//                        // Jika pengguna menekan tombol "Tidak", tutup dialog tanpa menghapus item
//                        dialog.dismiss()
//                        adapter.notifyItemChanged(position)
//                    }
//
//                    val alertDialog = alertDialogBuilder.create()
//                    alertDialog.show()
//                }
//            }
//
//            val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
//            itemTouchHelper.attachToRecyclerView(binding.rvParfumeCart)
        }
    }
}