package com.example.ujimuna.presentation

import com.example.ujimuna.data.repository.ExaminerRepository

class GetExaminersByMahasiswaUseCase(private val examinerRepository: ExaminerRepository) {
    fun execute(mahasiswaNim: String) = examinerRepository.getByMahasiswaNim(mahasiswaNim)
}