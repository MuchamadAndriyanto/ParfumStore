package com.example.parfum.view.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.parfum.R
import com.example.parfum.databinding.ListFavParfumeBinding
import com.example.parfum.dbroom.ItemParfumeFavorite
import com.example.parfum.model.ParfumeDetail

class FavoriteParfumAdapter (private var dataList: List<ItemParfumeFavorite>) : RecyclerView.Adapter<FavoriteParfumAdapter.ViewHolder>() {
    class ViewHolder(var binding: ListFavParfumeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListFavParfumeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: FavoriteParfumAdapter.ViewHolder, position: Int) {
        val movie = dataList[position]

        holder.binding.imgPhoto.setImageResource(movie.image)
        holder.binding.tvParfume.text = movie.name
        holder.binding.tvIsi.text = movie.isi
        holder.binding.tvPrice.text = movie.price
        holder.binding.tvDolar.text = movie.harga

        holder.binding.parfumeDetail.setOnClickListener {
            val id = dataList[position].id
            val image = dataList[position].image
            val nameParfum = dataList[position].name
            val isiParfum =dataList[position].isi
            val price = dataList[position].price
            val harga = dataList[position].harga
            val detail = ParfumeDetail(id,image,nameParfum,isiParfum,price,harga)

            val data = Bundle()
            data.putParcelable("data_parfume",detail)
            Navigation.findNavController(it).navigate(R.id.action_favoriteFragment_to_detailFragment,data)

        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
}