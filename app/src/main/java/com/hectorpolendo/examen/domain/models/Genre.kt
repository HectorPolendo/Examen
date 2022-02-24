package com.hectorpolendo.examen.domain.models

import com.hectorpolendo.examen.data.database.entities.GenreEntity
import com.hectorpolendo.examen.data.network.pojos.GenreResult

class Genre (
    val id: Int,
    val name: String
)

fun GenreResult.resultToModel() = Genre(
    id,
    name
)

fun GenreEntity.entityToModel() = Genre(
    id,
    name,
)