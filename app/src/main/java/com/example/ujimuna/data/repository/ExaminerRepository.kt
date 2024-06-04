package com.example.ujimuna.data.repository

import com.example.ujimuna.data.local.dao.ExaminerDao
import com.example.ujimuna.data.local.entities.Examiner

class ExaminerRepository(private val examinerDao: ExaminerDao) {
    fun getByMahasiswaNim(mahasiswaNim: String): List<Examiner> = examinerDao.getByMahasiswaNim(mahasiswaNim)
    fun insertAll(examiners: List<Examiner>) = examinerDao.insertAll(examiners)
}