package com.hectorpolendo.examen.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hectorpolendo.examen.data.database.entities.*

@Database(entities = [MostPopularEntity::class, PlayingNowEntity::class, UpcomingEntity::class, TopRatedEntity::class, TvAiringTodayEntity::class, TvPopularEntity::class, TvTopRatedEntity::class, GenreEntity::class, FavoriteEntity::class], version = 1, exportSchema = false)
@TypeConverters(GenresTypeConverter::class)
abstract class MoviesDatabase: RoomDatabase() {
    abstract fun movieDao(): MoviesDao
}