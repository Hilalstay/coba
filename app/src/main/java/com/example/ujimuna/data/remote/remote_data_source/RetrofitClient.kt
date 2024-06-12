package com.example.ujimuna.data.remote.remote_data_source

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder


class RetrofitClient {
    companion object {
        private const val BASE_URL = "http://127.0.0.1:8000/"

        private val retrofit by lazy {
            val gson = GsonBuilder().setLenient().create()
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        val apiService: ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }
    }
}