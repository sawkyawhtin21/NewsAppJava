package com.skh.json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.skh.json.Api.ApiClient
import com.skh.json.model.PostItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //getPosts()
        getPostDetail()
    }
    fun getPosts(){
        val apiClient = ApiClient()
        val apiCall = apiClient.postApiService.getPost()

        apiCall.enqueue(object:retrofit2.Callback<ArrayList<PostItem>>{
            override fun onFailure(call: Call<ArrayList<PostItem>>, t: Throwable) {
                txt_test.text=t.toString()
                Toast.makeText(
                    applicationContext,
                    t.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onResponse(
                call: Call<ArrayList<PostItem>>,
                response: Response<ArrayList<PostItem>>
            ) {
                recyclerView.apply {
                    layoutManager= LinearLayoutManager(context)
                    adapter=PostAdapter(response.body()!!)
                }
              txt_test.text=response.body().toString()
                Toast.makeText(
                    applicationContext,
                    response.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

        })


    }
        fun getPostDetail() {
            val apiClient = ApiClient()
            val apiCall = apiClient.postApiService.getPostWithID(2)

            apiCall.enqueue(object:retrofit2.Callback<PostItem>{
                override fun onFailure(call: Call<PostItem>, t: Throwable) {
                   txt_test.text=t.toString()
                    Toast.makeText(
                        applicationContext,
                        t.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onResponse(
                    call: Call<PostItem>,
                    response: Response<PostItem>
                ) {
                   // recyclerView.apply {
                    //    layoutManager= LinearLayoutManager(context)
                    //    adapter=PostAdapter(response.body()!!)
                  //  }
               txt_test.text=response.body().toString()
                    Toast.makeText(
                        applicationContext,
                        response.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

            })
        }

}
