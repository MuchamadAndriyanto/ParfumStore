package com.example.parfum.dbroom.cart

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ItemCart::class], version = 1, exportSchema = false)
abstract class CartDatabase : RoomDatabase() {

    abstract fun itemCartDao(): ItemCartDao
}
