package com.example.parfum.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.parfum.dbroom.cart.DbModuleCart
import com.example.parfum.dbroom.cart.ItemCart
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    private val itemCartDao = DbModuleCart(application.applicationContext).itemCartDao

    fun getAllCartItems(): LiveData<List<ItemCart>> {
        return itemCartDao.getAllCartItems()
    }

    suspend fun insertCartItem(cartItem: ItemCart) {
        itemCartDao.insertCartItem(cartItem)
    }

    suspend fun deleteCartItem(itemId: Int) {
        itemCartDao.deleteCartItem(itemId)
    }

    fun isItemInCart(newItem: ItemCart): Boolean {
        val cartItems = getAllCartItems().value
        return cartItems?.any { it.name == newItem.name } ?: false
    }



}
