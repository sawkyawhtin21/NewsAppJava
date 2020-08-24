package com.skh.foodparadise.api

import com.skh.foodparadise.model.Categories
import com.skh.foodparadise.model.Category
import com.skh.foodparadise.model.Country
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CategoryApiClient {
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
  //  companion object{
  //     val API_KEY = ""
  //  }

//    private var retrofit: Retrofit? = null

       private val apiInterface: MealApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            MealApiInterface::class.java
        )
    }

    fun getCategory(): Call<Categories> {
        return apiInterface.getCategories()
    }
    fun getCountries(
        country: String
    ): Call<Country> {
        return apiInterface.getCountry(country)
    }

}