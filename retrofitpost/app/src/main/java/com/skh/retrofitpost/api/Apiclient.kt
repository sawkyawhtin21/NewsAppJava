package com.skh.retrofitpost.api

import com.skh.retrofitpost.model.model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiclient {

    private val BASE_URL = "http://food-delivery-shwe-sin-soe.khaingthinkyi.me/api/setup/"
    private var apiInterface: Apiinterface

    init {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        apiInterface = retrofit.create(Apiinterface::class.java)
    }

    fun addCity(s: String): Call<model> {
        return apiInterface.addCity(s)
    }
}