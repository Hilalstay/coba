package com.example.ujimuna.data.remote.remote_data_source

import com.example.ujimuna.data.remote.model.LoginRequest
import com.example.ujimuna.data.remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}