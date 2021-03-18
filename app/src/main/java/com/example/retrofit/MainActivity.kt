package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.retrofit.Network.RetrofitBuilder
import com.example.retrofit.Network.UserInfo
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        RetrofitBuilder.api.getUserInfo().enqueue(object : retrofit2.Callback<UserInfo> {

            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                val userinfo = response.body()!!
                binding.login.setText(userinfo?.userId.toString())
                binding.following.setText(userinfo?.following.toString())
                binding.followers.setText(userinfo?.followers.toString())
                Log.d(TAG, "onResponse: 유저아이디: ${userinfo?.userId}, 팔로워: ${userinfo?.followers}, 팔로잉: ${userinfo?.following} ")
            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Log.d("error", t.message.toString())
            }

        })



    }
}

