package com.ahmed.networkide.repo

import com.ahmed.networkide.remote.MyjsonApi
import java.util.concurrent.Executors

class Repository(val api: MyjsonApi) {

    fun getUsers(callback: Result) {
        val excutor = Executors.newSingleThreadExecutor()
        excutor.execute {
            callback.onLoading()
            val result = api.getUser().execute()
            if (result.isSuccessful) {
                callback.onSuccess(result.body()!!)
            } else {
                callback.onError(result.errorBody()?.string().toString())

            }
        }
    }

    fun getPosts(callback: Result){
        val executors = Executors.newSingleThreadExecutor()
        executors.execute {
            callback.onLoading()
            val result = api.getPosts().execute()
            if (result.isSuccessful){
                callback.onSuccess(result.body()!!)

            }else{
                callback.onError(result.errorBody()?.string().toString())
            }

        }

    }

    interface Result {
        fun onSuccess(response: Any)
        fun onError(error: String)
        fun onLoading()
    }
}