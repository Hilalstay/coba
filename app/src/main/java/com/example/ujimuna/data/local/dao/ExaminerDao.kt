package com.example.ujimuna.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ujimuna.data.local.entities.Examiner

@Dao
interface ExaminerDao {
    @Query("SELECT * FROM examiner WHERE mahasiswaNim = :mahasiswaNim")
    fun getByMahasiswaNim(mahasiswaNim: String): List<Examiner>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(examiners: List<Examiner>)
}