package com.skh.retrofitpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skh.retrofitpost.api.Apiclient
import com.skh.retrofitpost.model.City
import com.skh.retrofitpost.model.model
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiCall()
    }

    fun apiCall() {
        var apiclient = Apiclient()
        val call = apiclient.addCity("Yangon")

        call.enqueue(object : Callback<model> {
            override fun onFailure(call: Call<model>, t: Throwable) {
                txt_test.text = t.toString()
            }

            override fun onResponse(call: Call<model>, response: Response<model>) {
                txt_test.text = response.body().toString()
            }

        })
    }
}