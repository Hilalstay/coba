package com.example.ujimuna.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.ujimuna.R
import com.example.ujimuna.presentation.DosenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DosenActivity : AppCompatActivity() {

    private val dosenViewModel: DosenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dosen)

        // Observe data and update UI
        dosenViewModel.dosen.observe(this, { dosen ->
            // Update UI with dosen data
        })

        // Fetch dosen data
        val nip = intent.getStringExtra("NIP")
        if (nip != null) {
            dosenViewModel.fetchDosen(nip)
        }
    }
}