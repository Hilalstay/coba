package com.example.ujimuna.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ujimuna.data.local.entities.Dosen

@Dao
interface DosenDao {
    @Query("SELECT * FROM dosen")
    fun getAll(): List<Dosen>

    @Query("SELECT * FROM dosen WHERE nip = :nip")
    fun getByNIP(nip: String): Dosen?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(dosens: List<Dosen>)
}