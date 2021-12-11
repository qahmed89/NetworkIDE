package com.ahmed.networkide.remote

import com.ahmed.networkide.model.UserModel
import com.ahmed.networkide.model.posts.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface MyjsonApi {
    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("users")
    fun getUser(): Call<UserModel>

    @GET("posts")
    fun getPosts(): Call<PostModel>

}