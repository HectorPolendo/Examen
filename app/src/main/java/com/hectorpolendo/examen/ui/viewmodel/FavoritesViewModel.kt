package com.hectorpolendo.examen.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.FavoriteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {
    private val _favorites = MutableLiveData<List<FavoriteEntity>>()
    val favorites: LiveData<List<FavoriteEntity>> get() = _favorites

    fun onCreate(){
        viewModelScope.launch {
            _favorites.postValue(repository.getFavoritesFromDatabase())
        }
    }
}