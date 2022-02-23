package com.hectorpolendo.examen.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hectorpolendo.examen.data.database.entities.GenresTypeConverter
import com.hectorpolendo.examen.data.database.entities.MostPopularEntity
import com.hectorpolendo.examen.data.database.entities.PlayingNowEntity
import com.hectorpolendo.examen.data.database.entities.UpcomingEntity

@Database(entities = [MostPopularEntity::class, PlayingNowEntity::class, UpcomingEntity::class], version = 1, exportSchema = false)
@TypeConverters(GenresTypeConverter::class)
abstract class MoviesDatabase: RoomDatabase() {
    abstract fun movieDao(): MoviesDao
}