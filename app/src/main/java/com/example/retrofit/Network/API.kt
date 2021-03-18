package com.example.retrofit.Network

import android.telecom.Call
import retrofit2.http.GET
import javax.security.auth.callback.Callback

interface API {
    @GET("users/daeyeong1573")// baseUrl +   "user/유저아이디"
    fun getUserInfo(

    ): retrofit2.Call<UserInfo>

}