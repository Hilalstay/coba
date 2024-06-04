package com.example.ujimuna.domain.usecase

import com.example.ujimuna.data.repository.JadwalRepository

class GetJadwalUseCase(private val jadwalRepository: JadwalRepository) {
    fun execute(mahasiswaNim: String) = jadwalRepository.getByMahasiswaNim(mahasiswaNim)
}
