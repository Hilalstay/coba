package com.example.ujimuna.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ujimuna.data.local.entities.Jadwal

@Dao
interface JadwalDao {
    @Query("SELECT * FROM jadwal WHERE mahasiswaNim = :mahasiswaNim")
    fun getByMahasiswaNim(mahasiswaNim: String): Jadwal?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(jadwals: List<Jadwal>)
}