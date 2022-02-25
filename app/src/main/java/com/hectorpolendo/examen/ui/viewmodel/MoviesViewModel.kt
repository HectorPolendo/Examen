package com.hectorpolendo.examen.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.domain.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _popular = MutableLiveData<List<Movie>>()
    val popular: LiveData<List<Movie>> get() = _popular

    private val _playingNow = MutableLiveData<List<Movie>>()
    val playingNow: LiveData<List<Movie>> get() = _playingNow

    private val _upcoming = MutableLiveData<List<Movie>>()
    val upcoming: LiveData<List<Movie>> get() = _upcoming

    private val _topRated = MutableLiveData<List<Movie>>()
    val topRated: LiveData<List<Movie>> get() = _topRated

    fun onCreate(){
        viewModelScope.launch {
            _popular.postValue(repository.getMostPopularFromDatabase())
            _playingNow.postValue(repository.getPlayingNowFromDatabase())
            _upcoming.postValue(repository.getUpcomingFromDatabase())
            _topRated.postValue(repository.getTopRatedFromDatabase())
        }
    }
}