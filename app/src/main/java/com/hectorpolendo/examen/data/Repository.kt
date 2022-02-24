package com.hectorpolendo.examen.data

import com.hectorpolendo.examen.data.database.MoviesDao
import com.hectorpolendo.examen.data.database.entities.*
import com.hectorpolendo.examen.data.network.ServiceController
import com.hectorpolendo.examen.data.network.pojos.GenreResult
import com.hectorpolendo.examen.data.network.pojos.MovieResult
import com.hectorpolendo.examen.data.network.pojos.TvSeriesResult
import com.hectorpolendo.examen.domain.models.*
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

    suspend fun getMostPopularFromApi(page: Int):List<Movie>{
        val response: List<MovieResult> = controller.getMostPopular(page)
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

    suspend fun getPlayingNowFromApi(page: Int):List<Movie>{
        val response: List<MovieResult> = controller.getPlayinNow(page)
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
    UPCOMING
     **/
    suspend fun insertUpcoming(list: List<UpcomingEntity>){
        dao.insertUpcoming(list)
    }

    suspend fun getUpcomingFromApi(page: Int):List<Movie>{
        val response: List<MovieResult> = controller.getUpcoming(page)
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

    suspend fun getTopRatedFromApi(page: Int):List<Movie>{
        val response: List<MovieResult> = controller.getTopRated(page)
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
    /**
    TV SERIES AIRING NOW
     **/
    suspend fun insertAiringToday(list: List<TvAiringTodayEntity>){
        dao.insertAiringToday(list)
    }

    suspend fun getAiringTodayFromApi(page: Int):List<TvSerie>{
        val response: List<TvSeriesResult> = controller.getTvAiringToday(page)
        return response.map { it.resultToModel() }
    }

    suspend fun getAiringTodayFromDatabase(): List<TvSerie>{
        val response: List<TvAiringTodayEntity> = dao.readAiringToday()
        return response.map { it.entityToModel() }
    }

    suspend fun getAiringTodayFromDatabaseById(id: Int): TvSerie{
        val response: TvAiringTodayEntity = dao.readAiringTodayById(id)
        return response.entityToModel()
    }

    suspend fun deleteAiringToday(){
        dao.deleteAiringToday()
    }
    /**
    TV SERIES POPULAR
     **/
    suspend fun insertTvPopular(list: List<TvPopularEntity>){
        dao.insertTvPopular(list)
    }

    suspend fun getTvPopularFromApi(page: Int):List<TvSerie>{
        val response: List<TvSeriesResult> = controller.getTvPopular(page)
        return response.map { it.resultToModel() }
    }

    suspend fun getTvPopularFromDatabase(): List<TvSerie>{
        val response: List<TvPopularEntity> = dao.readTvPopular()
        return response.map { it.entityToModel() }
    }

    suspend fun getTvPopularFromDatabaseById(id: Int): TvSerie{
        val response: TvPopularEntity = dao.readTvPopularById(id)
        return response.entityToModel()
    }

    suspend fun deleteTvPopular(){
        dao.deleteTvPopular()
    }
    /**
    TV SERIES TOP RATED
     **/
    suspend fun insertTvTopRated(list: List<TvTopRatedEntity>){
        dao.insertTvTopRated(list)
    }

    suspend fun getTvTopRatedFromApi(page: Int):List<TvSerie>{
        val response: List<TvSeriesResult> = controller.getTvTopRated(page)
        return response.map { it.resultToModel() }
    }

    suspend fun getTvTopRatedFromDatabase(): List<TvSerie>{
        val response: List<TvTopRatedEntity> = dao.readTvTopRated()
        return response.map { it.entityToModel() }
    }

    suspend fun getTvTopRatedFromDatabaseById(id: Int): TvSerie{
        val response: TvTopRatedEntity = dao.readTvTopRatedById(id)
        return response.entityToModel()
    }

    suspend fun deleteTvTopRated(){
        dao.deleteTvTopRated()
    }
    /**
    TV SERIES TOP RATED
     **/
    suspend fun insertGenres(list: List<GenreEntity>){
        dao.insertGenres(list)
    }

    suspend fun getGenresFromApi():List<Genre>{
        val response: List<GenreResult> = controller.getGenres()
        return response.map { it.resultToModel() }
    }

    suspend fun getGenresFromDatabase(): List<Genre>{
        val response: List<GenreEntity> = dao.readGenres()
        return response.map { it.entityToModel() }
    }

    suspend fun getGenreFromDatabaseById(id: Int): Genre{
        val response: GenreEntity = dao.readGenreById(id)
        return response.entityToModel()
    }

    suspend fun deleteGenres(){
        dao.deleteGenres()
    }
}