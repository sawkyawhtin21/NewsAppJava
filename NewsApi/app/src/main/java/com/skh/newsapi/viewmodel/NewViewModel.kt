package com.skh.newsapi.viewmodel

import android.location.GnssNavigationMessage
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skh.newsapi.api.ApiClient
import com.skh.newsapi.model.News
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewViewModel : ViewModel() {
    private var result: MutableLiveData<News> = MutableLiveData()
    private var errorMessage: MutableLiveData<String> = MutableLiveData()
    private var loading: MutableLiveData<Boolean> = MutableLiveData()
    private var errorStatus: MutableLiveData<Boolean> = MutableLiveData()

    fun getResult(): LiveData<News> = result
    fun getErrorMessage(): LiveData<String> = errorMessage
    fun getLoading(): LiveData<Boolean> = loading
    fun getErrorstatus(): LiveData<Boolean> = errorStatus
    fun loadResult() {

        var apiClient = ApiClient()
        var apiCall = apiClient.getTopHeadlines("us","Technology","")


        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
               // log.d("Error>>>>", t.toString())
                loading.value = false
                errorStatus.value = true
                errorMessage.value = t.toString()
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                result.value = response.body()
                loading.value = false
                errorStatus.value = false
            }
        })
    }
}



