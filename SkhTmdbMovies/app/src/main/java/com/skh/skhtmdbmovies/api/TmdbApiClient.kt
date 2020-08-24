package com.skh.skhtmdbmovies.api

import com.skh.skhtmdbmovies.model.Result
import com.skh.skhtmdbmovies.model.Tmdb
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TmdbApiClient {
    //private val retrofit: Retrofit
    val BASE_URL = "https://developers.themoviedb.org/3/"
    companion object {
        val API_KEY= "0bf10d92d51209797358b3e248ed89d4"
    }

    private val apiInterface: TmdbApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            TmdbApiInterface::class.java
        )
    }

    fun getToprated(

        apiKey: String
    ): Call<Tmdb>{
        return apiInterface.getTopRated(apiKey)
    }


}