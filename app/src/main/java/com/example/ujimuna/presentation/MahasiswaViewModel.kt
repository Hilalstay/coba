package com.example.ujimuna.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ujimuna.domain.usecase.GetJadwalUseCase
import com.example.ujimuna.domain.usecase.GetMahasiswaUseCase
import kotlinx.coroutines.launch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ujimuna.data.local.database.AppDatabase
import com.example.ujimuna.data.local.entities.Mahasiswa
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MahasiswaViewModel(application: Application) : AndroidViewModel(application) {
    private val mahasiswaDao = AppDatabase.getDatabase(application).mahasiswaDao()

    suspend fun getMahasiswaByNIM(nim: String): Mahasiswa? {
        return withContext(Dispatchers.IO) {
            mahasiswaDao.getByNIM(nim)
        }
    }
}