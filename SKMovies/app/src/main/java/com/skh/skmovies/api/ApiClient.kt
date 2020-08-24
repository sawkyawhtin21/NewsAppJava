package com.skh.skmovies.api

import com.skh.skmovies.model.nowplaying.NowPlaying
import com.skh.skmovies.modeldetails.ModelDetails
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "https://api.themoviedb.org/3/movie/"

    companion object {
        val Moviesid = "299536"
        val API_KEY = "0bf10d92d51209797358b3e248ed89d4"
    }

    private val apiInterface: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            ApiInterface::class.java
        )
    }

    fun getNowPlaying(
        apiKey: String
    ): Call<NowPlaying> {
        return apiInterface.getNowPlaying(apiKey)
    }

    fun getMovieDetail(
        moviesid: Int,
        apiKey: String
    ): Call<ModelDetails> {
        return apiInterface.getMovieDetail(moviesid.toInt(), API_KEY)
    }

}