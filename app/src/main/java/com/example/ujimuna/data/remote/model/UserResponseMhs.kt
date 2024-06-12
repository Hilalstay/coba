package com.example.ujimuna.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserResponseMhs(
    @SerializedName("message")
    @Expose
    val message: String,

    @SerializedName("data")
    @Expose
    val data: UserData
)