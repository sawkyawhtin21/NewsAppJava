package com.skh.skmovies.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skh.skmovies.api.ApiClient
import com.skh.skmovies.model.nowplaying.NowPlaying
import com.skh.skmovies.modeldetails.Genre
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private var result: MutableLiveData<NowPlaying> = MutableLiveData()
    fun getResult(): LiveData<NowPlaying> = result

    fun loadMovies() {
        var apiClient = ApiClient()
        val call = apiClient.getNowPlaying(ApiClient.API_KEY)

        call.enqueue(object : Callback<NowPlaying> {
            override fun onFailure(call: Call<NowPlaying>, t: Throwable) {
                Log.d("Error>>>>", t.toString())
            }

            override fun onResponse(call: Call<NowPlaying>, response: Response<NowPlaying>) {
                result.value = response.body()
                Log.d("Error" , "${response.body()}")
            }

        })
    }
    private var result2: MutableLiveData<Genre> = MutableLiveData()
    fun getResult2() : LiveData<Genre> = result2

    fun loadNews2(){
        var apiClient=ApiClient()
        var call=apiClient.getMovieDetail(299536,ApiClient.API_KEY)

        call.enqueue(object : Callback<Genre> {
            override fun onFailure(call: Call<Genre>, t: Throwable){
                Log.d("Error>>>>", t.toString())
            }
            override fun onResponse(call: Call<Genre>, response: Response<Genre>){
                result2.value = response.body()!!
            }
        })

    }
}