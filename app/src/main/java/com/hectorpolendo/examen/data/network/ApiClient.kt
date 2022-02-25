package com.hectorpolendo.examen.data.network

import com.hectorpolendo.examen.data.network.pojos.GenreResponse
import com.hectorpolendo.examen.data.network.pojos.MovieResponse
import com.hectorpolendo.examen.data.network.pojos.TvSeriesResponse
import com.hectorpolendo.examen.data.network.pojos.VideoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    @GET("movie/popular?")
    suspend fun getMostPopular(
        @Query("api_key") api: String,
        @Query("language") language: String,
        @Query("page") page: Int): Response<MovieResponse>

    @GET("movie/now_playing?")
    suspend fun getPlayinNow(
        @Query("api_key") api: String,
        @Query("language") language: String,
        @Query("page") page: Int): Response<MovieResponse>

    @GET("movie/upcoming?")
    suspend fun getUpcoming(
        @Query("api_key") api: String,
        @Query("language") language: String,
        @Query("page") page: Int): Response<MovieResponse>

    @GET("movie/top_rated?")
    suspend fun getTopRated(
        @Query("api_key") api: String,
        @Query("language") language: String,
        @Query("page") page: Int): Response<MovieResponse>

    @GET("genre/movie/list?")
    suspend fun getMovieGenres(
        @Query("api_key") api: String,
        @Query("language") language: String): Response<GenreResponse>

    @GET("genre/tv/list?")
    suspend fun getSerieGenres(
        @Query("api_key") api: String,
        @Query("language") language: String): Response<GenreResponse>

    @GET("tv/airing_today?")
    suspend fun getAiringToday(
        @Query("api_key") api: String,
        @Query("language") language: String,
        @Query("page") page: Int): Response<TvSeriesResponse>

    @GET("tv/popular?")
    suspend fun getTvPopular(
        @Query("api_key") api: String,
        @Query("language") language: String,
        @Query("page") page: Int): Response<TvSeriesResponse>

    @GET("tv/top_rated?")
    suspend fun getTvTopRated(
        @Query("api_key") api: String,
        @Query("language") language: String,
        @Query("page") page: Int): Response<TvSeriesResponse>

    @GET("movie/{movie_id}/videos?")
    suspend fun getVideosByMovie(
        @Path("movie_id") id: Int,
        @Query("api_key") api: String): Response<VideoResponse>

    @GET("tv/{tv_id}/videos?")
    suspend fun getVideosBySerie(
        @Path("tv_id") id: Int,
        @Query("api_key") api: String): Response<VideoResponse>

}