package com.ahmed.networkide.model

import com.google.gson.annotations.SerializedName

class UserModel : ArrayList<UserItem>()


data class UserItem(
    @SerializedName("id")
    val idUser: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val emailUser: String,

    @SerializedName("address")
    val address: Address
)

data class Address(
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")

    val suite: String,
    @SerializedName("city")

    val city: String,
    @SerializedName("zipcode")

    val zipcode: String
)

