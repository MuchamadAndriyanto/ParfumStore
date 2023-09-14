package com.example.parfum.dbroom.cart

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemCartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItem: ItemCart)

    @Query("SELECT * FROM ItemCart")
    fun getAllCartItems(): LiveData<List<ItemCart>>

    @Query("DELETE FROM ItemCart WHERE id = :itemId")
    suspend fun deleteCartItem(itemId: kotlin.Int)
}