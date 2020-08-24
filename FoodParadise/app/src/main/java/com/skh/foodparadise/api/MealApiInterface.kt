package com.skh.foodparadise.api

import com.skh.foodparadise.model.Categories
import com.skh.foodparadise.model.Country
import com.skh.foodparadise.model.Meals
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiInterface {
    @GET("categories.php")
    fun getCategories(
       //  @Path("api_key") apikey: String
    ): Call<Categories>

    @GET("filter.php")
    fun getIngredient(
    @Query("i") meals: String
    ): Call<Meals>

    @GET("filter.php")
    fun getCountry(
    @Query("a")  country: String
    ): Call<Country>

}