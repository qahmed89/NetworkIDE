package com.ahmed.networkide.model.posts

import com.google.gson.annotations.SerializedName


 class PostModel:ArrayList<PostItem>()

data class PostItem(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String

)
