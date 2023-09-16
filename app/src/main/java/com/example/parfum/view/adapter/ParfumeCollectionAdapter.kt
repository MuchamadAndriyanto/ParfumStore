package com.example.parfum.view.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parfum.R
import com.example.parfum.databinding.ListFavParfumeBinding
import com.example.parfum.databinding.ListParfumeCollectionBinding
import com.example.parfum.model.ListParfumeCollection
import com.example.parfum.model.ParfumeDetail

class ParfumeCollectionAdapter(private val dataList: ArrayList<ListParfumeCollection>) : RecyclerView.Adapter<ParfumeCollectionAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListParfumeCollectionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListParfumeCollectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        Glide.with(holder.itemView.context).load(item.image).into(holder.binding.ivBackground)

        holder.itemView.setOnClickListener {
            val id = item.id
            val image = item.image
            val nameParfum = item.parfume
            val isiParfum = item.isi
            val price = item.price
            val harga = item.dolar
            val detail = ParfumeDetail(id, image, nameParfum, isiParfum, price, harga)

            val dataParfumCollection = Bundle()
            dataParfumCollection.putParcelable("data_parfume", detail)
            it.findNavController().navigate(R.id.action_homeFragment_to_detailFragment, dataParfumCollection)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}