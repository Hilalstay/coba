package com.example.ujimuna.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ujimuna.domain.usecase.GetJadwalUseCase
import com.example.ujimuna.domain.usecase.GetMahasiswaUseCase
import kotlinx.coroutines.launch

class MahasiswaViewModel(
    private val getMahasiswaUseCase: GetMahasiswaUseCase,
    private val getJadwalUseCase: GetJadwalUseCase
) : ViewModel() {

    fun getMahasiswa(nim: String) {
        viewModelScope.launch {
            val mahasiswa = getMahasiswaUseCase.execute(nim)
            // Update UI with mahasiswa data
        }
    }

    fun getJadwal(nim: String) {
        viewModelScope.launch {
            val jadwal = getJadwalUseCase.execute(nim)
            // Update UI with jadwal data
        }
    }
}