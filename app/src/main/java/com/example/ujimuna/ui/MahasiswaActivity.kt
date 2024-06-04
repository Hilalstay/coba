package com.example.ujimuna.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.ujimuna.R
import com.example.ujimuna.presentation.MahasiswaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MahasiswaActivity : AppCompatActivity() {

    private val mahasiswaViewModel: MahasiswaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahasiswa)

        // Observe data and update UI
        mahasiswaViewModel.mahasiswa.observe(this, { mahasiswa ->
            // Update UI with mahasiswa data
        })

        // Fetch mahasiswa data
        val nim = intent.getStringExtra("NIM")
        if (nim != null) {
            mahasiswaViewModel.fetchMahasiswa(nim)
        }
    }
}