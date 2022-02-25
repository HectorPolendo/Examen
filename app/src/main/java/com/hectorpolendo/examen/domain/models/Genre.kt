package com.hectorpolendo.examen.domain.models

import com.hectorpolendo.examen.data.database.entities.MovieGenreEntity
import com.hectorpolendo.examen.data.database.entities.SerieGenreEntity
import com.hectorpolendo.examen.data.network.pojos.GenreResult

class Genre (
    val id: Int,
    val name: String
)

fun GenreResult.resultToModel() = Genre(
    id,
    name
)

fun MovieGenreEntity.entityToModel() = Genre(
    id,
    name,
)

fun SerieGenreEntity.entityToModel() = Genre(
    id,
    name,
)