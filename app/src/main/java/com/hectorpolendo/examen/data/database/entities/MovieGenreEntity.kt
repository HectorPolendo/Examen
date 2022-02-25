package com.hectorpolendo.examen.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hectorpolendo.examen.domain.models.Genre

@Entity(tableName = "MovieGenres")
data class MovieGenreEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)

fun Genre.modelToMovieEntity() = MovieGenreEntity(
    id,
    name
)
