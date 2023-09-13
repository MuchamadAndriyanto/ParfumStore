package com.example.parfum.view.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.parfum.R
import com.example.parfum.model.ListParfumeCollection
import com.example.parfum.model.ParfumeDetail

class ParfumeCollectionAdapter(private val dataList: ArrayList<ListParfumeCollection>) : RecyclerView.Adapter<ParfumeCollectionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var img = view.findViewById<ImageView>(R.id.ivBackground)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParfumeCollectionAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_parfume_collection, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ParfumeCollectionAdapter.ViewHolder, position: Int) {
        holder.img.setImageResource(dataList[position].image)

        holder.itemView.setOnClickListener {
            val id = dataList[position].id
            val image = dataList[position].image
            val nameParfum = dataList[position].parfume
            val isiParfum =dataList[position].isi
            val price = dataList[position].price
            val harga = dataList[position].dolar
            val detail = ParfumeDetail(id,image,nameParfum,isiParfum,price,harga)

            val dataParfumPopular = Bundle()
            dataParfumPopular.putParcelable("data_parfume",detail)
            it.findNavController().navigate(R.id.action_homeFragment_to_detailFragment,dataParfumPopular)
        }

    }
    override fun getItemCount(): Int {
        return dataList.size
    }
}