package com.ahmed.networkide.remote

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface MyjsonApi {
    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
    @GET("users")
    fun getUser () : Call<ResponseBody>

    @GET("posts")
    fun getPosts() :Call<ResponseBody>

}