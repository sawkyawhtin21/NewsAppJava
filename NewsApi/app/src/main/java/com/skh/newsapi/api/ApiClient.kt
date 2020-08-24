package com.skh.newsapi.api

import com.skh.newsapi.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL =
        "https://newsapi.org/v2/"
  //  companion object{
   //     var API_KEY ="0bca4c6ac5bd43c29f47ddbbaa0edcee"
   // }
  companion object{
      val API_KEY = "e5a7abe04cb44e41843fc49f810f6591"
  }
    private var apiInterface: NewsApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            NewsApiInterface::class.java
        )
    }


   // private var retrofits : Retrofit ?= null

  //  val apiInterface: NewsApiInterface

    init {
        // if (retrofit == null)
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            NewsApiInterface::class.java
        )
    }

    fun getTopHeadlines( country:String, category:String, apikey: String): Call<News> {
        return apiInterface.getTopHeadlines(
            "us",
        "0bca4c6ac5bd43c29f47ddbbaa0edcee"
        )
    }
}