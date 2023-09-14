package com.example.parfum.dbroom.cart

import android.content.Context
import androidx.room.Room

class DbModuleCart(private val context: Context) {
    private val db = Room.databaseBuilder(context, CartDatabase::class.java, "cart_database")
        .allowMainThreadQueries()
        .build()

    val itemCartDao = db.itemCartDao()
}
