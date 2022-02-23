package com.hectorpolendo.examen.domain.usecases

import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.movieToTopRated
import com.hectorpolendo.examen.domain.models.Movie
import javax.inject.Inject

class TopRatedUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(): List<Movie>{
        val result = repository.getTopRatedFromApi()
        return if(result.isNotEmpty()){
            repository.deleteTopRated()
            repository.insertTopRated(result.map { it.movieToTopRated() })
            result
        }else{
            repository.getTopRatedFromDatabase()
        }
    }
}