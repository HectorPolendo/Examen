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
    MOVIES GENRES
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieGenres(movieGenres: List<MovieGenreEntity>)

    @Query("SELECT * FROM MovieGenres")
    suspend fun readMovieGenres(): List<MovieGenreEntity>

    @Query("SELECT * FROM MovieGenres WHERE id = :id")
    suspend fun readMovieGenreById(id: Int): MovieGenreEntity

    @Query("DELETE FROM MovieGenres")
    suspend fun deleteMovieGenres()
    /**
    SERIES GENRES
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSerieGenres(serieGenres: List<SerieGenreEntity>)

    @Query("SELECT * FROM SerieGenres")
    suspend fun readSerieGenres(): List<SerieGenreEntity>

    @Query("SELECT * FROM SerieGenres WHERE id = :id")
    suspend fun readSerieGenreById(id: Int): SerieGenreEntity

    @Query("DELETE FROM SerieGenres")
    suspend fun deleteSerieGenres()
    /**
    FAVORITES
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorites(fav: FavoriteEntity)

    @Query("SELECT * FROM Favorites")
    suspend fun readFavorites(): List<FavoriteEntity>

    @Query("SELECT * FROM Favorites WHERE id = :id")
    suspend fun readFavoriteById(id: Int): FavoriteEntity

    @Query("DELETE FROM Favorites WHERE id = :id")
    suspend fun deleteFavorite(id: Int)
    /**
    VIDEOS
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideos(video: VideoEntity)

    @Query("SELECT * FROM Video")
    suspend fun readVideos(): List<VideoEntity>

    @Query("SELECT * FROM Video WHERE id = :id")
    suspend fun readVideoById(id: Int): VideoEntity

    @Query("DELETE FROM Video")
    suspend fun deleteVideos()
}