package com.skh.json.Api

import com.skh.json.model.PostItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
        fun getPost(): Call <ArrayList<PostItem>>

    @GET("posts")
    fun getPosts(): Call<ArrayList<PostItem>>
    @GET ("post/{postID}")
    fun getPostWithID(
        @Path("postID") postID : Int):
            Call<PostItem>


}