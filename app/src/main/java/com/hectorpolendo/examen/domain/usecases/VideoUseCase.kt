package com.hectorpolendo.examen.domain.usecases

import com.hectorpolendo.examen.data.Repository
import com.hectorpolendo.examen.data.database.entities.videoToEntity
import com.hectorpolendo.examen.domain.models.Video
import javax.inject.Inject

class VideoUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int, isMovie: Boolean): List<Video>{
        var result: List<Video> = if(isMovie){
            repository.getMovieVideosFromApi(id)
        }else{
            repository.getSerieVideosFromApi(id)
        }

        return if(result.isNotEmpty()){
            repository.deleteVideos()

            result.map {
                if(it.type.contains("Trailer")){
                    repository.insertVideos(it.videoToEntity())
                }
            }
            repository.getVideosFromDatabase()
        }else{
            repository.getVideosFromDatabase()
        }
    }
}