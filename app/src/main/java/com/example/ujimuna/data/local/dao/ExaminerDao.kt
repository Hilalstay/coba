package com.example.ujimuna.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ujimuna.data.local.entities.Examiner
import com.example.ujimuna.data.local.entities.Jadwal

@Dao
interface ExaminerDao {
    @Query("SELECT * FROM examiner WHERE examiner1Nip = :nip OR examiner2Nip = :nip OR examiner3Nip = :nip OR examiner4Nip = :nip")
    fun getByExaminerNip(nip: String): List<Examiner>

    @Query("SELECT * FROM examiner WHERE studentNim = :nip")
    fun getByDosenNip(nip: String): List<Examiner>
    @Query("SELECT * FROM examiner WHERE studentNim = :studentNim")
    fun getByMahasiswaNim(studentNim: String): Jadwal?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(examiners: List<Examiner>)
}