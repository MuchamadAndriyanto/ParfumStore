package com.example.parfum.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.parfum.dbroom.DbModule
import com.example.parfum.dbroom.ItemParfumeFavorite
import com.example.parfum.model.ParfumeDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel  @Inject constructor(application: Application) : AndroidViewModel(application) {
    private val itemParfumeDao = DbModule(application.applicationContext).itemFavoritDao

    fun tambahItemFavorit(parfumFavorite: ParfumeDetail) {
        val favoriteItem =ItemParfumeFavorite(
            parfumFavorite.id,
            parfumFavorite.parfume,
            parfumFavorite.isi,
            parfumFavorite.image,
            parfumFavorite.price,
            parfumFavorite.dolar
        )
        itemParfumeDao.tambahItemFavorit(favoriteItem)
    }

    fun getAllFavorite(): LiveData<MutableList<ItemParfumeFavorite>> {
        return itemParfumeDao.getAllFavorite()
    }

    fun isFavoriteMovie(id: Int): Boolean {
        return itemParfumeDao.isFavoriteItem(id)
    }

    fun deleteFavorite(parfumFavorite: ParfumeDetail) {
        val favoriteItem = ItemParfumeFavorite(
            parfumFavorite.id,
            parfumFavorite.parfume,
            parfumFavorite.isi,
            parfumFavorite.image,
            parfumFavorite.price,
            parfumFavorite.dolar
        )
        itemParfumeDao.hapusItemFavorit(favoriteItem)
    }
}