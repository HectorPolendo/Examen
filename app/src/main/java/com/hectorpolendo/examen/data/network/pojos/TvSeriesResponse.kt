package com.hectorpolendo.examen.data.network.pojos

data class TvSeriesResponse(
    val page: Int,
    val results: List<TvSeriesResult>,
    val total_pages: Int,
    val total_results: Int
)