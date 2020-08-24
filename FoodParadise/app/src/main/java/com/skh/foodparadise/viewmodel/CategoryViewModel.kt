package com.skh.foodparadise.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skh.foodparadise.api.CategoryApiClient
import com.skh.foodparadise.model.Categories
import com.skh.foodparadise.model.Category
import com.skh.foodparadise.model.Country
import com.skh.foodparadise.model.MealXX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

 class CategoryViewModel: ViewModel () {
     private var result: MutableLiveData<Categories> = MutableLiveData()
     fun getResult(): LiveData<Categories> = result

     fun loadCategories() {
         var apiClient = CategoryApiClient()
         val call = apiClient.getCategory()

         call.enqueue(object : Callback<Categories> {
             override fun onFailure(call: Call<Categories>, t: Throwable) {
                 Log.d("Error>>>>",t.toString())
             }
             override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                 result.value = response.body()
             }
         })


     }
//     fun loadCountries() {
//         var apiClient = CategoryApiClient()
//         val call = apiClient.getCountries(country)
//
//         call.enqueue(object : Callback<Country> {
//             override fun onFailure(call: Call<Country>, t: Throwable) {
//                 Log.d("Error>>>>",t.toString())
//             }
//             override fun onResponse(call: Call<Country>, response: Response<Country>) {
//                 result.value = response.body()
//             }
//         })
//
//
//     }
 }