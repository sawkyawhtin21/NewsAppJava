package com.skh.skhtmdbmovies.api

import com.skh.skhtmdbmovies.model.Result
import okhttp3.MultipartBody
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.*

interface TmdbApiInterface {

    @GET("top-rated")
    fun getTopRated(
        @Query("apikey") apikey: String
    ): Call<Result>


}