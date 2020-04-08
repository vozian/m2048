package com.example.a2048multiplayer.data

import com.example.a2048multiplayer.data.model.LoginReq
import com.example.a2048multiplayer.data.model.RegisterReq
import com.example.a2048multiplayer.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("users/login")
    suspend fun login(@Body body: LoginReq): Response<User>


    @POST("users/register")
    suspend fun register(@Body body: RegisterReq): Response<User>
}