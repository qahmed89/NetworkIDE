package com.ahmed.networkide

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.ahmed.networkide.remote.ApiClient
import okhttp3.ResponseBody
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var apiClient : ApiClient
    lateinit var tvResponse : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResponse = findViewById(R.id.tvResonse)
         apiClient  =ApiClient()
       // val backGroundTask = BackGroundTask()
      //  backGroundTask.execute()
        apiClient.createMyJsonApi().getUser().enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
               if (response.isSuccessful){
                   val result = response.body()?.string().toString()
                   val userID=JSONArray(result).getJSONObject(1).getInt("id")

               }

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

        })

    }

    inner class BackGroundTask : AsyncTask<Void , Void , String>(){
        override fun doInBackground(vararg params: Void?): String {
            val result = apiClient.createMyJsonApi().getUser().execute()
            return result.body()?.string().toString()
        }

        override fun onPostExecute(result: String?) {
            val string = result
            tvResponse.text=string
            super.onPostExecute(result)
        }
    }
}