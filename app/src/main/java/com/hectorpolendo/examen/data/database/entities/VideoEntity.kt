package com.hectorpolendo.examen.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hectorpolendo.examen.domain.models.Movie
import com.hectorpolendo.examen.domain.models.Video

@Entity(tableName = "Video")
data class VideoEntity(
    @PrimaryKey(autoGenerate = false)
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

fun Video.videoToEntity() = VideoEntity(
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
