package com.hectorpolendo.examen.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.domain.models.Genre
import com.hectorpolendo.examen.domain.models.Movie
import com.hectorpolendo.examen.domain.models.TvSerie
import com.hectorpolendo.examen.domain.usecases.*
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
    private val airingTodayUseCase: AiringTodayUseCase,
    private val tvPopularUseCase: TvPopularUseCase,
    private val tvTopRatedUseCase: TvTopRatedUseCase,
    private val movieGenreUseCase: MovieGenreUseCase,
    private val serieGenreUseCase: SerieGenreUseCase,
    private val repository: Repository) : ViewModel() {

    private val _mostPopular = MutableLiveData<List<Movie>>()
    private val _playingNow = MutableLiveData<List<Movie>>()
    private val _upcoming = MutableLiveData<List<Movie>>()
    private val _topRated = MutableLiveData<List<Movie>>()
    private val _airingToday = MutableLiveData<List<TvSerie>>()
    private val _tvPopular = MutableLiveData<List<TvSerie>>()
    private val _tvTopRated = MutableLiveData<List<TvSerie>>()
    private val _movieGenres = MutableLiveData<List<Genre>>()
    private val _serieGenres = MutableLiveData<List<Genre>>()


    private val _progress = MutableLiveData<Int>()
    val progress: LiveData<Int> get() = _progress

    fun onCreate(context: Context){
        viewModelScope.launch {
            if(Method.isOnline(context)){
                /**LECTURA DE PELICULAS POPULARES*/
                _progress.postValue(0)
                val popular = mostPopularUseCase.invoke(1)
                if(!popular.isNullOrEmpty()){
                    _mostPopular.postValue(popular!!)
                }
                /**LECTURA DE PELICULAS ACTUALES*/
                _progress.postValue(11)
                val playingNow = playinNowUseCase.invoke(1)
                if(!playingNow.isNullOrEmpty()){
                    _playingNow.postValue(playingNow!!)
                }
                /**LECTURA DE PELICULAS PRÓXIMAS*/
                _progress.postValue(22)
                val upcoming = upcomingUseCase.invoke(1)
                if(!upcoming.isNullOrEmpty()){
                    _upcoming.postValue(upcoming!!)
                }
                /**LECTURA DE PELICULAS MEJOR VALORADAS*/
                _progress.postValue(33)
                val top = topRatedUseCase.invoke(1)
                if(!top.isNullOrEmpty()){
                    _topRated.postValue(top!!)
                }
                /**LECTURA DE SERIES TRASNMITIDAS HOY*/
                _progress.postValue(44)
                val airing = airingTodayUseCase.invoke(1)
                if(!airing.isNullOrEmpty()){
                    _airingToday.postValue(airing!!)
                }
                /**LECTURA DE SERIES POPULARES*/
                _progress.postValue(55)
                val tvpopular = tvPopularUseCase.invoke(1)
                if(!tvpopular.isNullOrEmpty()){
                    _tvPopular.postValue(tvpopular!!)
                }
                /**LECTURA DE SERIES POPULARES*/
                _progress.postValue(66)
                val tvtoprated = tvTopRatedUseCase.invoke(1)
                if(!tvtoprated.isNullOrEmpty()){
                    _tvTopRated.postValue(tvtoprated!!)
                }
                /**LECTURA DE GÉNEROS DE PELICULAS*/
                _progress.postValue(77)
                val movieGenres = movieGenreUseCase.invoke()
                if(!movieGenres.isNullOrEmpty()){
                    _movieGenres.postValue(movieGenres!!)
                }
                /**LECTURA DE GÉNEROS DE SERIES*/
                _progress.postValue(88)
                val seriesGenres = serieGenreUseCase.invoke()
                if(!seriesGenres.isNullOrEmpty()){
                    _serieGenres.postValue(seriesGenres!!)
                }
                _progress.postValue(100)
            }else{
                _progress.postValue(0)
                _mostPopular.postValue(repository.getMostPopularFromDatabase())

                _progress.postValue(11)
                _playingNow.postValue(repository.getPlayingNowFromDatabase())

                _progress.postValue(22)
                _upcoming.postValue(repository.getUpcomingFromDatabase())

                _progress.postValue(33)
                _topRated.postValue(repository.getTopRatedFromDatabase())

                _progress.postValue(44)
                _airingToday.postValue(repository.getAiringTodayFromDatabase())

                _progress.postValue(55)
                _tvPopular.postValue(repository.getTvPopularFromDatabase())

                _progress.postValue(66)
                _tvTopRated.postValue(repository.getTvTopRatedFromDatabase())

                _progress.postValue(77)
                _movieGenres.postValue(repository.getMovieGenresFromDatabase())

                _progress.postValue(88)
                _serieGenres.postValue(repository.getSerieGenresFromDatabase())

                _progress.postValue(100)
            }
        }
    }
}