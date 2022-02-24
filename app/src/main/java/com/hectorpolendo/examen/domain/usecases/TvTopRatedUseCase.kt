package com.hectorpolendo.examen.domain.usecases

import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.serieToTvTopRated
import com.hectorpolendo.examen.domain.models.TvSerie
import javax.inject.Inject

class TvTopRatedUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(page: Int): List<TvSerie>{
        val result = repository.getTvTopRatedFromApi(page)
        return if(result.isNotEmpty()){
            repository.deleteTvTopRated()
            repository.insertTvTopRated(result.map { it.serieToTvTopRated() })
            result
        }else{
            repository.getTvTopRatedFromDatabase()
        }
    }
}