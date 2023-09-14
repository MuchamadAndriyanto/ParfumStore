package com.example.parfum.dbroom.cart

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class ItemCart(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "name_parfume")
    var name: String,
    @ColumnInfo(name = "isi_parfum")
    var isi: String,
    @ColumnInfo(name = "image")
    var image: Int,
    @ColumnInfo(name = "price")
    var price: String,
    @ColumnInfo(name = "harga")
    var harga: String
) :Parcelable