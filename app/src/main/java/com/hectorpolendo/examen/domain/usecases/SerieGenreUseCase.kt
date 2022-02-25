package com.hectorpolendo.examen.domain.usecases

import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.modelToSerieEntity
import com.hectorpolendo.examen.domain.models.Genre
import javax.inject.Inject

class SerieGenreUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<Genre>{
        val result = repository.getSerieGenresFromApi()
        return if(result.isNotEmpty()){
            repository.deleteSerieGenres()
            repository.insertSerieGenres(result.map { it.modelToSerieEntity() })
            result
        }else{
            repository.getSerieGenresFromDatabase()
        }
    }
}