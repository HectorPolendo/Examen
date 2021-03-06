package com.hectorpolendo.examen.data.network

import com.hectorpolendo.examen.data.network.pojos.*
import com.hectorpolendo.examen.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ServiceController @Inject constructor(private val api: ApiClient) {
    suspend fun getMostPopular(page: Int): List<MovieResult>{
        return withContext(Dispatchers.IO){
            val response = api.getMostPopular(Constants.API_KEY, Constants.LANGUAGE, page)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getPlayinNow(page: Int): List<MovieResult>{
        return withContext(Dispatchers.IO){
            val response = api.getPlayinNow(Constants.API_KEY, Constants.LANGUAGE, page)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getUpcoming(page: Int): List<MovieResult>{
        return withContext(Dispatchers.IO){
            val response = api.getUpcoming(Constants.API_KEY, Constants.LANGUAGE, page)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getTopRated(page: Int): List<MovieResult>{
        return withContext(Dispatchers.IO){
            val response = api.getTopRated(Constants.API_KEY, Constants.LANGUAGE, page)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getTvAiringToday(page: Int): List<TvSeriesResult>{
        return withContext(Dispatchers.IO){
            val response = api.getAiringToday(Constants.API_KEY, Constants.LANGUAGE, page)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getTvPopular(page: Int): List<TvSeriesResult>{
        return withContext(Dispatchers.IO){
            val response = api.getTvPopular(Constants.API_KEY, Constants.LANGUAGE, page)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getTvTopRated(page: Int): List<TvSeriesResult>{
        return withContext(Dispatchers.IO){
            val response = api.getTvTopRated(Constants.API_KEY, Constants.LANGUAGE, page)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getMovieGenres(): List<GenreResult>{
        return withContext(Dispatchers.IO){
            val response = api.getMovieGenres(Constants.API_KEY, Constants.LANGUAGE)
            response.body()?.genres ?: emptyList()
        }
    }

    suspend fun getSerieGenres(): List<GenreResult>{
        return withContext(Dispatchers.IO){
            val response = api.getSerieGenres(Constants.API_KEY, Constants.LANGUAGE)
            response.body()?.genres ?: emptyList()
        }
    }

    suspend fun getVideosByMovie(id: Int): List<VideoResult>{
        return withContext(Dispatchers.IO){
            val response = api.getVideosByMovie(id, Constants.API_KEY)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getVideosBySerie(id: Int): List<VideoResult>{
        return withContext(Dispatchers.IO){
            val response = api.getVideosBySerie(id, Constants.API_KEY)
            response.body()?.results ?: emptyList()
        }
    }
}