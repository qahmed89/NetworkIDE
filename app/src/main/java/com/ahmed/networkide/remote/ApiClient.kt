package com.ahmed.networkide.remote

import retrofit2.Retrofit

class ApiClient {

    fun createMyJsonApi () :MyjsonApi{
        return Retrofit.Builder()
            .baseUrl(MyjsonApi.BASE_URL)
            .build().create(MyjsonApi::class.java)
    }
}