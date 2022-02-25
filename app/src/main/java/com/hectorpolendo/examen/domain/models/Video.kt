package com.hectorpolendo.examen.domain.models

import com.hectorpolendo.examen.data.database.entities.VideoEntity
import com.hectorpolendo.examen.data.network.pojos.VideoResult

data class Video(
    val id: String,
    val iso_3166_1: String,
    val iso_639_1: String,
    val key: String,
    val name: String,
    val official: Boolean,
    val published_at: String,
    val site: String,
    val size: Int,
    val type: String
)

fun VideoResult.resultToModel() = Video(
    id,
    iso_3166_1,
    iso_639_1,
    key,
    name,
    official,
    published_at,
    site,
    size,
    type
)

fun VideoEntity.entityToModel() = Video(
    id,
    iso_3166_1,
    iso_639_1,
    key,
    name,
    official,
    published_at,
    site,
    size,
    type
)
