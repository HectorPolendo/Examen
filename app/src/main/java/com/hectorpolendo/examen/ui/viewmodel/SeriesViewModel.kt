package com.hectorpolendo.examen.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.domain.models.Movie
import com.hectorpolendo.examen.domain.models.TvSerie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _popular = MutableLiveData<List<TvSerie>>()
    val popular: LiveData<List<TvSerie>> get() = _popular

    private val _topRated = MutableLiveData<List<TvSerie>>()
    val topRated: LiveData<List<TvSerie>> get() = _topRated

    private val _airingToday = MutableLiveData<List<TvSerie>>()
    val airingToday: LiveData<List<TvSerie>> get() = _airingToday

    fun onCreate(){
        viewModelScope.launch {
            _popular.postValue(repository.getTvPopularFromDatabase())
            _topRated.postValue(repository.getTvTopRatedFromDatabase())
            _airingToday.postValue(repository.getAiringTodayFromDatabase())
        }
    }
}