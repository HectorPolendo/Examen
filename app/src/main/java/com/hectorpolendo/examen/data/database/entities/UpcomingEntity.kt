package com.hectorpolendo.examen.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hectorpolendo.examen.domain.models.Movie

@Entity(tableName = "Upcoming")
data class UpcomingEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val adult: Boolean?,
    val backdrop_path: String?,
    val genre_ids: List<String>?,
    val original_language: String?,
    val original_title: String?,
    val overview: String,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
)

fun Movie.movieToUpcoming() = UpcomingEntity(
    id,
    adult,
    backdrop_path,
    genre_ids,
    original_language,
    original_title,
    overview,
    popularity,
    poster_path,
    release_date,
    title,
    video,
    vote_average,
    vote_count
)
