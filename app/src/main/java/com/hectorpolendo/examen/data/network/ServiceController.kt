package com.hectorpolendo.examen.data.network

import com.hectorpolendo.examen.data.network.pojos.MovieResult
import com.hectorpolendo.examen.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ServiceController @Inject constructor(private val api: ApiClient) {
    suspend fun getMostPopular(): List<MovieResult>{
        return withContext(Dispatchers.IO){
            val response = api.getMostPopular(Constants.API_KEY, Constants.LANGUAGE)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getPlayinNow(): List<MovieResult>{
        return withContext(Dispatchers.IO){
            val response = api.getPlayinNow(Constants.API_KEY, Constants.LANGUAGE)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getUpcoming(): List<MovieResult>{
        return withContext(Dispatchers.IO){
            val response = api.getUpcoming(Constants.API_KEY, Constants.LANGUAGE)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getTopRated(): List<MovieResult>{
        return withContext(Dispatchers.IO){
            val response = api.getTopRated(Constants.API_KEY, Constants.LANGUAGE)
            response.body()?.results ?: emptyList()
        }
    }
}