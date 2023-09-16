package com.example.parfum.view.adapter

import android.content.ReceiverCallNotAllowedException
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parfum.R
import com.example.parfum.databinding.ListParfumeCollectionBinding
import com.example.parfum.databinding.ListParfumePopularBinding
import com.example.parfum.model.ListParfumePopular
import com.example.parfum.model.ParfumeDetail

class ParfumePopularAdapter(private val dataList: ArrayList<ListParfumePopular>) : RecyclerView.Adapter<ParfumePopularAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListParfumePopularBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListParfumePopularBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        Glide.with(holder.itemView.context).load(item.image).into(holder.binding.imgPhoto)

        holder.binding.tvParfume.text = item.parfume
        holder.binding.tvIsi.text = item.isi
        holder.binding.tvPrice.text = item.price
        holder.binding.tvDolar.text = item.dolar

        holder.itemView.setOnClickListener {
            val id = item.id
            val image = item.image
            val nameParfum = item.parfume
            val isiParfum = item.isi
            val price = item.price
            val harga = item.dolar
            val detail = ParfumeDetail(id, image, nameParfum, isiParfum, price, harga)

            val dataParfumPopular = Bundle()
            dataParfumPopular.putParcelable("data_parfume", detail)
            it.findNavController().navigate(R.id.action_homeFragment_to_detailFragment, dataParfumPopular)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}