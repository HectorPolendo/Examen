package com.hectorpolendo.examen.domain.usecases

import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.movieToPlayingNow
import com.hectorpolendo.examen.domain.models.Movie
import javax.inject.Inject

class PlayinNowUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(page: Int): List<Movie>{
        val result = repository.getPlayingNowFromApi(page)
        return if(result.isNotEmpty()){
            repository.deletePlayingNow()
            repository.insertPlayinNow(result.map { it.movieToPlayingNow() })
            result
        }else{
            repository.getPlayingNowFromDatabase()
        }
    }
}