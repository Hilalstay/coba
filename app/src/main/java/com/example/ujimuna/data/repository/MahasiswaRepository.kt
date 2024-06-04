package com.example.ujimuna.data.repository;

import com.example.ujimuna.data.local.dao.MahasiswaDao
import com.example.ujimuna.data.local.entities.Mahasiswa

class MahasiswaRepository(private val mahasiswaDao: MahasiswaDao) {
    fun getByNIM(nim: String): Mahasiswa? = mahasiswaDao.getByNIM(nim)
    fun insertAll(mahasiswas: List<Mahasiswa>) = mahasiswaDao.insertAll(mahasiswas)
}