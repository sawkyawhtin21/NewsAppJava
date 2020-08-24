package com.skh.skhtmdbmovies.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skh.skhtmdbmovies.api.TmdbApiClient
import com.skh.skhtmdbmovies.model.Result
import com.skh.skhtmdbmovies.model.Tmdb
import kotlinx.android.synthetic.main.item_movies.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tmdbviewodel : ViewModel() {
    private var result: MutableLiveData<Tmdb> = MutableLiveData()

    fun getResult(): LiveData<Tmdb> = result

    fun loadNews() {
        var apiClient = TmdbApiClient()
        val call = apiClient.getToprated(
          TmdbApiClient.API_KEY
        )
        call.enqueue(object: Callback<Tmdb> {
            override fun onFailure(call: Call<Tmdb>, t: Throwable) {
                Log.d("Error>>>>",t.toString())
            }

            override fun onResponse(call: Call<Tmdb>, response: Response<Tmdb>) {
                result.value = response.body()
            }

        })
    }



}