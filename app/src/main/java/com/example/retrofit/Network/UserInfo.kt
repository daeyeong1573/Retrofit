package com.example.retrofit.Network

import com.google.gson.annotations.SerializedName

data class UserInfo(

    val userId: String,
    val followers: Int ,
    val following: Int
)