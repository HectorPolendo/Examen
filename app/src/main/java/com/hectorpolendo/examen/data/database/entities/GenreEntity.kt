package com.hectorpolendo.examen.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hectorpolendo.examen.domain.models.Genre

@Entity(tableName = "Genres")
data class GenreEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)

fun Genre.modelToEntity() = GenreEntity(
    id,
    name
)
