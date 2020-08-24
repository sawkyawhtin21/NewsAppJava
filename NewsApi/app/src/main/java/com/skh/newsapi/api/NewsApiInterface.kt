package com.skh.newsapi.api

import com.skh.newsapi.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApiInterface {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apikey") apikey: String
    ): Call<News>

}
