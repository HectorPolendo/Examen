package com.hectorpolendo.examen.domain.usecases

import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.modelToMovieEntity
import com.hectorpolendo.examen.domain.models.Genre
import javax.inject.Inject

class MovieGenreUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(): List<Genre>{
        val result = repository.getMoviesGenresFromApi()
        return if(result.isNotEmpty()){
            repository.deleteMovieGenres()
            repository.insertMovieGenres(result.map { it.modelToMovieEntity() })
            result
        }else{
            repository.getMovieGenresFromDatabase()
        }
    }
}