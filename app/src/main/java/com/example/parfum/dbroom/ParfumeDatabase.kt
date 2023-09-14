package com.example.parfum.dbroom

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ItemParfumeFavorite::class], version = 1, exportSchema = false)
abstract class ParfumeDatabase : RoomDatabase() {
    abstract fun itemParfumeDao(): ItemParfumeDao
}