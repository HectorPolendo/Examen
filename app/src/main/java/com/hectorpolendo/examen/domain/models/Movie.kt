package com.hectorpolendo.examen.domain.models

import com.hectorpolendo.examen.data.database.entities.MostPopularEntity
import com.hectorpolendo.examen.data.database.entities.PlayingNowEntity
import com.hectorpolendo.examen.data.database.entities.TopRatedEntity
import com.hectorpolendo.examen.data.database.entities.UpcomingEntity
import com.hectorpolendo.examen.data.network.pojos.MovieResult

data class Movie(
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

fun MovieResult.resultToModel() = Movie(
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

fun MostPopularEntity.entityToModel() = Movie(
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

fun PlayingNowEntity.entityToModel() = Movie(
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

fun UpcomingEntity.entityToModel() = Movie(
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

fun TopRatedEntity.entityToModel() = Movie(
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