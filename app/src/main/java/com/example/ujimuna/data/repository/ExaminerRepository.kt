package com.example.ujimuna.data.repository

import com.example.ujimuna.data.local.dao.ExaminerDao
import com.example.ujimuna.data.local.entities.Examiner
import com.example.ujimuna.data.local.entities.Jadwal

class ExaminerRepository(private val examinerDao: ExaminerDao) {
    fun getByExaminerNip(nip: String): List<Examiner> = examinerDao.getByExaminerNip(nip)
    fun getByDosenNip(nip: String): List<Examiner> = examinerDao.getByDosenNip(nip)
    fun getByMahasiswaNim(studentNim: String): Jadwal? = examinerDao.getByMahasiswaNim(studentNim)
    fun insertAll(examiners: List<Examiner>) = examinerDao.insertAll(examiners)
}