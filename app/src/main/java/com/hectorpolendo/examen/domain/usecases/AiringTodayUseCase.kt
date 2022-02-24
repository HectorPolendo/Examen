package com.hectorpolendo.examen.domain.usecases

import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.serieToAiring
import com.hectorpolendo.examen.domain.models.TvSerie
import javax.inject.Inject

class AiringTodayUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(page: Int): List<TvSerie>{
        val result = repository.getAiringTodayFromApi(page)
        return if(result.isNotEmpty()){
            repository.deleteAiringToday()
            repository.insertAiringToday(result.map { it.serieToAiring() })
            result
        }else{
            repository.getAiringTodayFromDatabase()
        }
    }
}