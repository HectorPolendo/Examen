package com.hectorpolendo.examen.data.network

import com.hectorpolendo.examen.data.network.pojos.GenreResponse
import com.hectorpolendo.examen.data.network.pojos.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("movie/popular?")
    suspend fun getMostPopular(
        @Query("api_key") api: String,
        @Query("language") language: String): Response<MovieResponse>

    @GET("movie/now_playing?")
    suspend fun getPlayinNow(
        @Query("api_key") api: String,
        @Query("language") language: String): Response<MovieResponse>

    @GET("movie/upcoming?")
    suspend fun getUpcoming(
        @Query("api_key") api: String,
        @Query("language") language: String): Response<MovieResponse>

    @GET("movie/top_rated?")
    suspend fun getTopRated(
        @Query("api_key") api: String,
        @Query("language") language: String): Response<MovieResponse>

    @GET("genre/movie/list?")
    suspend fun getGenres(
        @Query("api_key") api: String,
        @Query("language") language: String): Response<GenreResponse>

}