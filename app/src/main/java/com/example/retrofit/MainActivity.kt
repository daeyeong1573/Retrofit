package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofit.Network.RetrofitBuilder
import com.example.retrofit.Network.UserInfo
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val mbinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mbinding.root)

        mbinding.btn.setOnClickListener {
            Toast.makeText(this, "테스트", Toast.LENGTH_SHORT).show()
            RetrofitBuilder.api.getUserInfo().enqueue(object : retrofit2.Callback<UserInfo> {
                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    val userinfo = response.body()!!
                    mbinding.followers.text = userinfo?.followers.toString()
                    mbinding.login.text = userinfo?.userId
                    mbinding.following.text = userinfo?.following.toString()
                    Log.d(TAG, "onResponse: 유저아이디: ${userinfo?.userId}, 팔로워: ${userinfo?.followers}, 팔로잉: ${userinfo?.following} ")

                }

                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    Log.d("error", t.message.toString())
                }

            })

        }
    }

}



