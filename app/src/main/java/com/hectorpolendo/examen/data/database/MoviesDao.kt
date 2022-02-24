package com.hectorpolendo.examen.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hectorpolendo.examen.data.database.entities.*

@Dao
interface MoviesDao {
    /**
     MOST POPULAR
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMostPopular(movies: List<MostPopularEntity>)

    @Query("SELECT * FROM MostPopular")
    suspend fun readMostPopular(): List<MostPopularEntity>

    @Query("SELECT * FROM MostPopular WHERE id = :id")
    suspend fun readMostPopularById(id: Int): MostPopularEntity

    @Query("DELETE FROM MostPopular")
    suspend fun deleteMostPopular()
    /**
    PLAYING NOW
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayingNow(movies: List<PlayingNowEntity>)

    @Query("SELECT * FROM PlayingNow")
    suspend fun readPlayingNow(): List<PlayingNowEntity>

    @Query("SELECT * FROM PlayingNow WHERE id = :id")
    suspend fun readPlayingNowById(id: Int): PlayingNowEntity

    @Query("DELETE FROM PlayingNow")
    suspend fun deletePlayingNow()
    /**
    UPCOMING
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcoming(movies: List<UpcomingEntity>)

    @Query("SELECT * FROM Upcoming")
    suspend fun readUpcoming(): List<UpcomingEntity>

    @Query("SELECT * FROM Upcoming WHERE id = :id")
    suspend fun readUpcomingById(id: Int): UpcomingEntity

    @Query("DELETE FROM Upcoming")
    suspend fun deleteUpcoming()
    /**
    TOP RATED
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRated(movies: List<TopRatedEntity>)

    @Query("SELECT * FROM TopRated")
    suspend fun readTopRated(): List<TopRatedEntity>

    @Query("SELECT * FROM TopRated WHERE id = :id")
    suspend fun readTopRatedById(id: Int): TopRatedEntity

    @Query("DELETE FROM TopRated")
    suspend fun deleteTopRated()
    /**
    AIRING TODAY
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAiringToday(movies: List<TvAiringTodayEntity>)

    @Query("SELECT * FROM TvAiringToday")
    suspend fun readAiringToday(): List<TvAiringTodayEntity>

    @Query("SELECT * FROM TvAiringToday WHERE id = :id")
    suspend fun readAiringTodayById(id: Int): TvAiringTodayEntity

    @Query("DELETE FROM TvAiringToday")
    suspend fun deleteAiringToday()
    /**
    TV POPULAR
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvPopular(movies: List<TvPopularEntity>)

    @Query("SELECT * FROM TvPopular")
    suspend fun readTvPopular(): List<TvPopularEntity>

    @Query("SELECT * FROM TvPopular WHERE id = :id")
    suspend fun readTvPopularById(id: Int): TvPopularEntity

    @Query("DELETE FROM TvPopular")
    suspend fun deleteTvPopular()
    /**
    TV TOP RATED
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvTopRated(movies: List<TvTopRatedEntity>)

    @Query("SELECT * FROM TvTopRated")
    suspend fun readTvTopRated(): List<TvTopRatedEntity>

    @Query("SELECT * FROM TvTopRated WHERE id = :id")
    suspend fun readTvTopRatedById(id: Int): TvTopRatedEntity

    @Query("DELETE FROM TvTopRated")
    suspend fun deleteTvTopRated()
    /**
    GENRES
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenres(genres: List<GenreEntity>)

    @Query("SELECT * FROM Genres")
    suspend fun readGenres(): List<GenreEntity>

    @Query("SELECT * FROM Genres WHERE id = :id")
    suspend fun readGenreById(id: Int): GenreEntity

    @Query("DELETE FROM Genres")
    suspend fun deleteGenres()
}