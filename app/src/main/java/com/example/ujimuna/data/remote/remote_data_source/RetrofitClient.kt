package com.example.ujimuna.data.remote.remote_data_source

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder


class RetrofitClient{
    fun getRetroClientInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("http://10.1.15.208:8000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}