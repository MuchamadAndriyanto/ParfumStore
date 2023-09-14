package com.example.parfum.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParfumeDetail(
    var id : Int,
    var image : Int,
    var parfume : String,
    var isi : String,
    var price : String,
    var dolar : String,
    var isFavorite: Boolean = false
) : Parcelable
