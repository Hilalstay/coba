package com.example.ujimuna.domain.usecase

import com.example.ujimuna.data.repository.MahasiswaRepository

class GetMahasiswaUseCase(private val mahasiswaRepository: MahasiswaRepository) {
    fun execute(nim: String) = mahasiswaRepository.getByNIM(nim)
}