package com.example.a2048multiplayer.data

import com.example.a2048multiplayer.data.model.LoginReq
import com.example.a2048multiplayer.data.model.RegisterReq
import com.example.a2048multiplayer.data.model.User
import com.example.a2048multiplayer.ui.MainActivity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

object Repo{
    private lateinit var server: Api
    var user: User? = null
    lateinit var activity: MainActivity

    fun init(activity: MainActivity){
        this.activity = activity
        server =  Retrofit.Builder()
            .baseUrl("http://192.168.1.103:3000/api/")
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(Api::class.java)
    }

    suspend fun login(login: String, password: String): User?{
        user = server.login(LoginReq(login,password)).body()
        return user
    }

    suspend fun register(login: String, email: String, password: String): User?{
        user = server.register(RegisterReq(login,email,password)).body()
        return user
    }
}
