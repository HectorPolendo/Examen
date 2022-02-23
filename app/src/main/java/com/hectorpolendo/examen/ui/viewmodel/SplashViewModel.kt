package com.hectorpolendo.examen.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.domain.models.Movie
import com.hectorpolendo.examen.domain.usecases.MostPopularUseCase
import com.hectorpolendo.examen.domain.usecases.PlayinNowUseCase
import com.hectorpolendo.examen.domain.usecases.TopRatedUseCase
import com.hectorpolendo.examen.domain.usecases.UpcomingUseCase
import com.hectorpolendo.examen.util.Method
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val mostPopularUseCase: MostPopularUseCase,
    private val playinNowUseCase: PlayinNowUseCase,
    private val upcomingUseCase: UpcomingUseCase,
    private val topRatedUseCase: TopRatedUseCase,
    private val repository: Repository) : ViewModel() {

    private val _mostPopular = MutableLiveData<List<Movie>>()
    private val _playingNow = MutableLiveData<List<Movie>>()
    private val _upcoming = MutableLiveData<List<Movie>>()
    private val _topRated = MutableLiveData<List<Movie>>()


    private val _progress = MutableLiveData<Int>()
    val progress: LiveData<Int> get() = _progress

    fun onCreate(context: Context){
        viewModelScope.launch {
            if(Method.isOnline(context)){
                /**LECTURA DE PELICULAS POPULARES*/
                _progress.postValue(0)
                val popular = mostPopularUseCase()
                if(!popular.isNullOrEmpty()){
                    _mostPopular.postValue(popular!!)
                }
                /**LECTURA DE PELICULAS ACTUALES*/
                _progress.postValue(25)
                val playingNow = playinNowUseCase()
                if(!playingNow.isNullOrEmpty()){
                    _playingNow.postValue(playingNow!!)
                }
                /**LECTURA DE PELICULAS PRÓXIMAS*/
                _progress.postValue(50)
                val upcoming = upcomingUseCase()
                if(!upcoming.isNullOrEmpty()){
                    _upcoming.postValue(upcoming!!)
                }
                /**LECTURA DE PELICULAS MEJOR VALORADAS*/
                _progress.postValue(75)
                val top = topRatedUseCase()
                if(!top.isNullOrEmpty()){
                    _upcoming.postValue(top!!)
                }
                /**LECTURA DE GÉNEROS*/
                _progress.postValue(75)
                val genres = topRatedUseCase()
                if(!genres.isNullOrEmpty()){
                    _upcoming.postValue(genres!!)
                }
                _progress.postValue(100)
            }else{
                _progress.postValue(0)
                _mostPopular.postValue(repository.getMostPopularFromDatabase())
                _progress.postValue(33)
                _playingNow.postValue(repository.getPlayingNowFromDatabase())
                _progress.postValue(100)
            }
        }
    }
}