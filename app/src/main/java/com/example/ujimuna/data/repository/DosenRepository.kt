package com.example.ujimuna.data.repository


import com.example.ujimuna.data.local.dao.DosenDao
import com.example.ujimuna.data.local.entities.Dosen

class DosenRepository(private val dosenDao: DosenDao) {
    fun getAll(): List<Dosen> = dosenDao.getAll()
    fun getByNIP(nip: String): Dosen? = dosenDao.getByNIP(nip)
    fun insertAll(dosens: List<Dosen>) = dosenDao.insertAll(dosens)
}