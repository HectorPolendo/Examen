package com.hectorpolendo.examen.domain.usecases

import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.movieToPlayingNow
import com.hectorpolendo.examen.data.database.entities.movieToUpcoming
import com.hectorpolendo.examen.domain.models.Movie
import javax.inject.Inject

class UpcomingUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(): List<Movie>{
        val result = repository.getUpcomingFromApi()
        return if(result.isNotEmpty()){
            repository.deleteUpcoming()
            repository.insertUpcoming(result.map { it.movieToUpcoming() })
            result
        }else{
            repository.getUpcomingFromDatabase()
        }
    }
}