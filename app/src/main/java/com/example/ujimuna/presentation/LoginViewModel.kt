package com.example.ujimuna.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ujimuna.data.remote.model.LoginRequest
import com.example.ujimuna.data.remote.remote_data_source.RetrofitClient
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    fun login(userName: String, password: String) {
        val loginRequest = LoginRequest(userName, password)

        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.login(loginRequest)
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        // Handle successful response
                        if (loginResponse.message == "berhasil login") {
                            val userData = loginResponse.token
                            if (userData != null) {
                                // Login success, handle user data
                                Log.d("Login", "Name: ${userData.name}, Username: ${userData.user_name}")
                            } else {
                                Log.e("Login", "User data is null")
                            }
                        } else {
                            // Handle other responses
                            Log.e("Login", "Login failed: ${loginResponse.message}")
                        }
                    } else {
                        Log.e("Login", "Response body is null")
                    }
                } else {
                    Log.e("Login", "Login failed with code ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("Login", "Login failed", e)
            }
        }
    }
}
