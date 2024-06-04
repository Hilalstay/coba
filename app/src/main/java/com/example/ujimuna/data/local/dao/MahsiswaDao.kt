package com.example.ujimuna.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ujimuna.data.local.entities.Mahasiswa

@Dao
interface MahasiswaDao {
    @Query("SELECT * FROM mahasiswa WHERE nim = :nim")
    fun getByNIM(nim: String): Mahasiswa?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(mahasiswas: List<Mahasiswa>)
}