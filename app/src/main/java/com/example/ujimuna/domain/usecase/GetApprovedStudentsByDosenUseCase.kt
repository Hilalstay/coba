package com.example.ujimuna.domain.usecase

import com.example.ujimuna.data.local.entities.Examiner
import com.example.ujimuna.data.repository.ExaminerRepository

class GetApprovedStudentsByDosenUseCase(private val examinerRepository: ExaminerRepository) {
    fun execute(dosenNip: String) = examinerRepository.getByDosenNip(dosenNip).filter { it.status == "approved" }
}