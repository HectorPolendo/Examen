package com.hectorpolendo.examen.data

import com.hectorpolendo.examen.data.database.MoviesDao
import com.hectorpolendo.examen.data.database.entities.MostPopularEntity
import com.hectorpolendo.examen.data.database.entities.PlayingNowEntity
import com.hectorpolendo.examen.data.database.entities.TopRatedEntity
import com.hectorpolendo.examen.data.database.entities.UpcomingEntity
import com.hectorpolendo.examen.data.network.ServiceController
import com.hectorpolendo.examen.data.network.pojos.MovieResult
import com.hectorpolendo.examen.domain.models.Movie
import com.hectorpolendo.examen.domain.models.entityToModel
import com.hectorpolendo.examen.domain.models.resultToModel
import javax.inject.Inject

class Repository @Inject constructor(
    private val controller: ServiceController,
    private val dao: MoviesDao
) {

    /**
     MOST POPULAR
     **/
    suspend fun insertMostPopular(list: List<MostPopularEntity>){
        dao.insertMostPopular(list)
    }

    suspend fun getMostPopularFromApi():List<Movie>{
        val response: List<MovieResult> = controller.getMostPopular()
        return response.map { it.resultToModel() }
    }

    suspend fun getMostPopularFromDatabase(): List<Movie>{
        val response: List<MostPopularEntity> = dao.readMostPopular()
        return response.map { it.entityToModel() }
    }

    suspend fun getMostPopularFromDatabaseById(id: Int): Movie{
        val response: MostPopularEntity = dao.readMostPopularById(id)
        return response.entityToModel()
    }

    suspend fun deleteMostPopular(){
        dao.deleteMostPopular()
    }

    /**
     PLAYIN NOW
     **/

    suspend fun insertPlayinNow(list: List<PlayingNowEntity>){
        dao.insertPlayingNow(list)
    }

    suspend fun getPlayingNowFromApi():List<Movie>{
        val response: List<MovieResult> = controller.getPlayinNow()
        return response.map { it.resultToModel() }
    }

    suspend fun getPlayingNowFromDatabase(): List<Movie>{
        val response: List<PlayingNowEntity> = dao.readPlayingNow()
        return response.map { it.entityToModel() }
    }

    suspend fun getPlayingNowFromDatabaseById(id: Int): Movie{
        val response: PlayingNowEntity = dao.readPlayingNowById(id)
        return response.entityToModel()
    }

    suspend fun deletePlayingNow(){
        dao.deletePlayingNow()
    }

    /**
    PLAYIN NOW
     **/
    suspend fun insertUpcoming(list: List<UpcomingEntity>){
        dao.insertUpcoming(list)
    }

    suspend fun getUpcomingFromApi():List<Movie>{
        val response: List<MovieResult> = controller.getUpcoming()
        return response.map { it.resultToModel() }
    }

    suspend fun getUpcomingFromDatabase(): List<Movie>{
        val response: List<UpcomingEntity> = dao.readUpcoming()
        return response.map { it.entityToModel() }
    }

    suspend fun getUpcomingFromDatabaseById(id: Int): Movie{
        val response: UpcomingEntity = dao.readUpcomingById(id)
        return response.entityToModel()
    }

    suspend fun deleteUpcoming(){
        dao.deleteUpcoming()
    }
    /**
    TOP RATED
     **/
    suspend fun insertTopRated(list: List<TopRatedEntity>){
        dao.insertTopRated(list)
    }

    suspend fun getTopRatedFromApi():List<Movie>{
        val response: List<MovieResult> = controller.getTopRated()
        return response.map { it.resultToModel() }
    }

    suspend fun getTopRatedFromDatabase(): List<Movie>{
        val response: List<TopRatedEntity> = dao.readTopRated()
        return response.map { it.entityToModel() }
    }

    suspend fun getTopRatedFromDatabaseById(id: Int): Movie{
        val response: TopRatedEntity = dao.readTopRatedById(id)
        return response.entityToModel()
    }

    suspend fun deleteTopRated(){
        dao.deleteTopRated()
    }
}