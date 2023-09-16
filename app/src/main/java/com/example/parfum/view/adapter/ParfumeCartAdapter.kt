package com.example.parfum.view.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.parfum.R
import com.example.parfum.databinding.ListCartParfumeBinding
import com.example.parfum.databinding.ListFavParfumeBinding
import com.example.parfum.dbroom.ItemParfumeFavorite
import com.example.parfum.dbroom.cart.ItemCart
import com.example.parfum.model.ParfumeDetail

class ParfumeCartAdapter(private var dataList: List<ItemCart>, private val onDeleteClickListener: (ItemCart) -> Unit
) : RecyclerView.Adapter<ParfumeCartAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: ListCartParfumeBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnDelete.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onDeleteClickListener.invoke(dataList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListCartParfumeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.binding.tvParfume.text = item.name
        holder.binding.tvIsi.text = item.isi
        holder.binding.tvPrice.text = item.price
        holder.binding.tvDolar.text = item.harga
        holder.binding.imgPhoto.setImageResource(item.image)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}