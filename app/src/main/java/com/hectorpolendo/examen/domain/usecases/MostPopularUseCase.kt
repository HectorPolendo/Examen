package com.hectorpolendo.examen.domain.usecases

import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.movieToPopular
import com.hectorpolendo.examen.domain.models.Movie
import javax.inject.Inject

class MostPopularUseCase @Inject constructor(
    private val repository: Repository) {

    suspend operator fun invoke(page: Int): List<Movie>{
        val result = repository.getMostPopularFromApi(page)
        return if(result.isNotEmpty()){
            repository.deleteMostPopular()
            repository.insertMostPopular(result.map { it.movieToPopular() })
            result
        }else{
            repository.getMostPopularFromDatabase()
        }
    }
}