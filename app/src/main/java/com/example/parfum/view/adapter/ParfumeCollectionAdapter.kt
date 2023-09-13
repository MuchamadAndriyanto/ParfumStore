package com.example.parfum.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.parfum.R
import com.example.parfum.model.ListParfumeCollection

class ParfumeCollectionAdapter(private val dataList: ArrayList<ListParfumeCollection>) : RecyclerView.Adapter<ParfumeCollectionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var img = view.findViewById<ImageView>(R.id.ivBackground)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParfumeCollectionAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_parfume_collection, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ParfumeCollectionAdapter.ViewHolder, position: Int) {
        holder.img.setImageResource(dataList[position].img)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}