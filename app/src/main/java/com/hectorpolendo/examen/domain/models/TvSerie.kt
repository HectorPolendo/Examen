package com.hectorpolendo.examen.domain.models

import com.hectorpolendo.examen.data.database.entities.TvAiringTodayEntity
import com.hectorpolendo.examen.data.database.entities.TvPopularEntity
import com.hectorpolendo.examen.data.database.entities.TvTopRatedEntity
import com.hectorpolendo.examen.data.network.pojos.TvSeriesResult

data class TvSerie (
    val id: Int?,
    val backdrop_path: String?,
    val first_air_date: String?,
    val genre_ids: List<String>?,
    val name: String?,
    val origin_country: List<String>?,
    val original_language: String?,
    val original_name: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val vote_average: Double?,
    val vote_count: Int?
)

fun TvSeriesResult.resultToModel() = TvSerie(
    id,
    backdrop_path,
    first_air_date,
    genre_ids,
    name,
    origin_country,
    original_language,
    original_name,
    overview,
    popularity,
    poster_path,
    vote_average,
    vote_count
)

fun TvAiringTodayEntity.entityToModel() = TvSerie(
    id,
    backdrop_path,
    first_air_date,
    genre_ids,
    name,
    origin_country,
    original_language,
    original_name,
    overview,
    popularity,
    poster_path,
    vote_average,
    vote_count
)

fun TvPopularEntity.entityToModel() = TvSerie(
    id,
    backdrop_path,
    first_air_date,
    genre_ids,
    name,
    origin_country,
    original_language,
    original_name,
    overview,
    popularity,
    poster_path,
    vote_average,
    vote_count
)

fun TvTopRatedEntity.entityToModel() = TvSerie(
    id,
    backdrop_path,
    first_air_date,
    genre_ids,
    name,
    origin_country,
    original_language,
    original_name,
    overview,
    popularity,
    poster_path,
    vote_average,
    vote_count
)