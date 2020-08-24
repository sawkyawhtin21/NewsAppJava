package com.skh.skhtmdbmovies.model

data class Tmdb(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)