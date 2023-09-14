package com.example.parfum.dbroom

import android.content.Context
import androidx.room.Room

class DbModule(private val context: Context) {
    private val db = Room.databaseBuilder(context, ParfumeDatabase::class.java, "itemfavorit.db")
        .allowMainThreadQueries()
        .build()

    val itemFavoritDao = db.itemParfumeDao()
}