package com.example.ujimuna.data.remote.remote_data_source

import com.example.ujimuna.data.remote.model.LoginRequest
import com.example.ujimuna.data.remote.model.LoginResponse
import com.example.ujimuna.data.remote.model.UserResponseMhs
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("mobile/login/")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("mobile/schedule/{nim}")
    fun getStudentData(@Path("nim") nim: String): Call<UserResponseMhs>
}