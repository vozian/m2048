package com.example.a2048multiplayer.data.model

data class LoginReq(
    var username: String,
    var password: String
)


data class RegisterReq(
    var username: String,
    var email: String,
    var password: String
)