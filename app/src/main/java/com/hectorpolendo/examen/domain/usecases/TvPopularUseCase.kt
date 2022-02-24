package com.hectorpolendo.examen.domain.usecases

import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.serieToTvPopular
import com.hectorpolendo.examen.domain.models.TvSerie
import javax.inject.Inject

data class TvPopularUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(page: Int): List<TvSerie>{
        val result = repository.getTvPopularFromApi(page)
        return if(result.isNotEmpty()){
            repository.deleteTvPopular()
            repository.insertTvPopular(result.map { it.serieToTvPopular() })
            result
        }else{
            repository.getTvPopularFromDatabase()
        }
    }
}