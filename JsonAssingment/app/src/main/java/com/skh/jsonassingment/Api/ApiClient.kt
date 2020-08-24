package com.skh.jsonassingment.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
        private val BASE_URL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"

        private var retrofit: Retrofit? = null
        init{
            /* fun getretrofitClient ():Retrofit?{*/
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            }
            /*}*/

        }
        var KingApiService = retrofit !! .create(
            ApiInterface::class.java)
    }




