package com.example.parfum.dbroom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemParfumeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahItemFavorit(parfumFavorite: ItemParfumeFavorite)

    @Query("SELECT * FROM ItemParfumeFavorite")
    fun getAllFavorite(): LiveData<MutableList<ItemParfumeFavorite>>

    @Query("SELECT EXISTS(SELECT id FROM ItemParfumeFavorite WHERE id = :id)")
    fun isFavoriteItem(id: Int): Boolean

    @Delete
    fun hapusItemFavorit(parfumFavorite: ItemParfumeFavorite)
}