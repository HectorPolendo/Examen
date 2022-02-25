package com.hectorpolendo.examen.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hectorpolendo.examen.domain.models.Genre


@Entity(tableName = "SerieGenres")
data class SerieGenreEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)

fun Genre.modelToSerieEntity() = SerieGenreEntity(
    id,
    name
)

