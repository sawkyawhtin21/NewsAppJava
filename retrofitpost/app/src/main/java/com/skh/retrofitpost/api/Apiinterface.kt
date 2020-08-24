package com.skh.retrofitpost.api

import android.telecom.Call
import com.skh.retrofitpost.model.City
import com.skh.retrofitpost.model.model
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Apiinterface {
    @FormUrlEncoded
    @POST("city")
    fun addCity(
    @Field("city_name") cityName:  String
    ): retrofit2.Call<model>
}