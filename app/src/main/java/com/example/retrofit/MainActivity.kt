package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.retrofit.Network.RetrofitBuilder
import com.example.retrofit.Network.UserInfo
import com.example.retrofit.Network.UserInfo2
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    val mbinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mbinding.root)

        mbinding.btn.setOnClickListener {
            RetrofitBuilder.api.getUserInfo().enqueue(object : retrofit2.Callback<UserInfo2> {
                override fun onResponse(call: Call<UserInfo2>, response: Response<UserInfo2>) {
                    val useinfo = response.body()!!
                    Log.d(TAG, "onResponse: 유저아이디: ${useinfo?.login}, 팔로워: ${useinfo?.followers}, 팔로잉: ${useinfo?.following} ")

                }

                override fun onFailure(call: Call<UserInfo2>, t: Throwable) {
                    Log.d("error", t.message.toString())
                }

            })

        }
    }

}



