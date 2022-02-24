package com.hectorpolendo.examen.domain.usecases

import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.modelToEntity
import com.hectorpolendo.examen.domain.models.Genre
import javax.inject.Inject

class GenreUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(): List<Genre>{
        val result = repository.getGenresFromApi()
        return if(result.isNotEmpty()){
            repository.deleteGenres()
            repository.insertGenres(result.map { it.modelToEntity() })
            result
        }else{
            repository.getGenresFromDatabase()
        }
    }
}