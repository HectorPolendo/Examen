package com.hectorpolendo.examen.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.toDatabaseFav
import com.hectorpolendo.examen.domain.models.Favorite
import com.hectorpolendo.examen.domain.models.Movie
import com.hectorpolendo.examen.domain.models.TvSerie
import com.hectorpolendo.examen.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> get() = _movie

    private val _tvSerie = MutableLiveData<TvSerie>()
    val tvSerie: LiveData<TvSerie> get() = _tvSerie

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    fun onCreate(id: Int){
        viewModelScope.launch {
            when(Constants.FROM){
                "POPULAR_MOVIE" -> _movie.postValue(repository.getMostPopularFromDatabaseById(id))

                "PLAYING_NOW" -> _movie.postValue(repository.getPlayingNowFromDatabaseById(id))

                "UPCOMING" -> _movie.postValue(repository.getUpcomingFromDatabaseById(id))

                "TOP_RATED_MOVIES" -> _movie.postValue(repository.getTopRatedFromDatabaseById(id))

                "POPULAR_SERIE" -> _tvSerie.postValue(repository.getTvPopularFromDatabaseById(id))

                "TOP_RATED_SERIE" -> _tvSerie.postValue(repository.getTvTopRatedFromDatabaseById(id))

                "AIRING_TODAY" -> _tvSerie.postValue(repository.getAiringTodayFromDatabaseById(id))
            }

            if(repository.getFavoriteFromDatabaseById(id)){
                _isFavorite.postValue(true)
            }else{
                _isFavorite.postValue(false)
            }
        }
    }

    fun changeFavorite(id: Int, image: String){
        viewModelScope.launch {
            if(repository.getFavoriteFromDatabaseById(id)){
                repository.deleteFavorite(id)
                _isFavorite.postValue(false)
            }else{
                val fav = Favorite(id, image, Constants.FROM!!)
                repository.insertFavorite(fav.toDatabaseFav())
                _isFavorite.postValue(true)
            }
        }
    }
}