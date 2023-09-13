package com.example.parfum.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class ListParfumePopular(
    var id : Int,
    var image : Int,
    var parfume : String,
    var isi : String,
    var price : String,
    var dolar : String
)