package com.example.ujimuna.domain.usecase

import com.example.ujimuna.data.repository.ExaminerRepository


class GetExaminersByDosenUseCase(private val examinerRepository: ExaminerRepository) {
    fun execute(dosenNip: String) = examinerRepository.getByDosenNip(dosenNip)
}