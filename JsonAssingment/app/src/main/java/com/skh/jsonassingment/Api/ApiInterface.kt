package com.skh.jsonassingment.Api

import com.skh.jsonassingment.model.KingItem
import com.skh.jsonassingment.model.QueenItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("King")
    fun getKing(): Call<ArrayList<KingItem>>
    interface ApiInterface {
        @GET("Queen")
        fun getQueen(): Call<ArrayList<QueenItem>>


    }


}
