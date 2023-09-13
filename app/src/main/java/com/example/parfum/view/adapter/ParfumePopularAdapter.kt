package com.example.parfum.view.adapter

import android.content.ReceiverCallNotAllowedException
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.parfum.R
import com.example.parfum.model.ListParfumePopular
import com.example.parfum.model.ParfumeDetail
import com.example.parfum.view.DetailFragment

class ParfumePopularAdapter(private val dataList: ArrayList<ListParfumePopular>) : RecyclerView.Adapter<ParfumePopularAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.findViewById<ImageView>(R.id.imgPhoto)
        var parfume = view.findViewById<TextView>(R.id.tvParfume)
        var isi = view.findViewById<TextView>(R.id.tvIsi)
        var price = view.findViewById<TextView>(R.id.tvPrice)
        var dolar = view.findViewById<TextView>(R.id.tvDolar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_parfume_popular, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.image.setImageResource(data.image)
        holder.parfume.setText(data.parfume)
        holder.isi.setText(data.isi)
        holder.price.setText(data.price)
        holder.dolar.setText(data.dolar)

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