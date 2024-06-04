package com.example.ujimuna.data.remote.model

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val token: String
)