package com.example.ujimuna.data.repository


import com.example.ujimuna.data.local.dao.JadwalDao
import com.example.ujimuna.data.local.entities.Jadwal

class JadwalRepository(private val jadwalDao: JadwalDao) {
    fun getByMahasiswaNim(mahasiswaNim: String): Jadwal? = jadwalDao.getByMahasiswaNim(mahasiswaNim)
    fun insertAll(jadwals: List<Jadwal>) = jadwalDao.insertAll(jadwals)
}