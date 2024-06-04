package com.example.ujimuna.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.ujimuna.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe login response and update UI
        loginViewModel.loginResponse.observe(viewLifecycleOwner, { response ->
            if (response.isSuccessful) {
                // Navigate to the next screen
            } else {
                // Show error message
            }
        })

        // Handle login button click
        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            val username = view.findViewById<EditText>(R.id.et_username).text.toString()
            val password = view.findViewById<EditText>(R.id.et_password).text.toString()
            loginViewModel.login(username, password)
        }
    }
}