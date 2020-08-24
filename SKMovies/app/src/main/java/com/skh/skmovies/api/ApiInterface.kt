package com.skh.skmovies.api

import com.skh.skmovies.model.nowplaying.NowPlaying
import com.skh.skmovies.modeldetails.ModelDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("now_playing")
    fun getNowPlaying(
        @Query("api_key") apikey: String
    ): Call<NowPlaying>

     @GET("{movie_id}")
     fun getMovieDetail(
         @Path ("movie_id") movie_id:Int,
         @Query("api_key") apikey: String
     ): Call<details>

}