package com.ahmed.networkide

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ahmed.networkide.model.UserModel
import com.ahmed.networkide.model.posts.PostModel
import com.ahmed.networkide.remote.ApiClient
import com.ahmed.networkide.repo.Repository
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var apiClient: ApiClient
    lateinit var tvName: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPostsBody: TextView
    lateinit var tvPostsTitle: TextView
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        progressBar = findViewById(R.id.progressBar)
        tvPostsBody = findViewById(R.id.tvPostsBody)
        tvPostsTitle = findViewById(R.id.tvPostTitle)

        apiClient = ApiClient()
        val rep = Repository(apiClient.createMyJsonApi())
        rep.getUsers(object : Repository.Result {
            override fun onSuccess(response: Any) {
                val userModel = response as UserModel
                runOnUiThread {
                    progressBar.visibility = View.GONE
                    tvName.text = userModel[0].name
                    tvEmail.text = userModel[0].emailUser
                }
                Log.i("Repository", userModel[0].emailUser)
            }

            override fun onError(error: String) {
                runOnUiThread {
                    progressBar.visibility = View.INVISIBLE
                    Snackbar.make(tvName, error, Snackbar.LENGTH_LONG).show()
                }
                Log.i("Repository", error)
            }

            override fun onLoading() {
                runOnUiThread {
                    progressBar.visibility = View.VISIBLE
                }
            }


        })

        rep.getPosts(object  : Repository.Result{
            override fun onSuccess(response: Any) {
            val postModel = response as PostModel
                runOnUiThread {
                    tvPostsBody.text = postModel[0].body
                    tvPostsTitle.text = postModel[0].title

                }
            }

            override fun onError(error: String) {

            }

            override fun onLoading() {

            }

        })

    }
}
