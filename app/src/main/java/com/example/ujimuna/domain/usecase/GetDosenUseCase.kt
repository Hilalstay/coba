package com.example.ujimuna.domain.usecase

import com.example.ujimuna.data.local.entities.Dosen
import com.example.ujimuna.data.repository.DosenRepository

class GetDosenUseCase(private val dosenRepository: DosenRepository) {
    fun execute(nip: String) = dosenRepository.getByNIP(nip)
}