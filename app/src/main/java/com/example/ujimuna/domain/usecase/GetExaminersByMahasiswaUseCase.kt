package com.example.ujimuna.domain.usecase

import com.example.ujimuna.data.repository.ExaminerRepository

class GetExaminersByMahasiswaUseCase(private val examinerRepository: ExaminerRepository) {
    fun execute(mahasiswaNim: String) = examinerRepository.getByMahasiswaNim(mahasiswaNim)
}