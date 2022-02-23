package com.hectorpolendo.examen.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hectorpolendo.examen.data.database.entities.MostPopularEntity
import com.hectorpolendo.examen.data.database.entities.PlayingNowEntity
import com.hectorpolendo.examen.data.database.entities.TopRatedEntity
import com.hectorpolendo.examen.data.database.entities.UpcomingEntity

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
}