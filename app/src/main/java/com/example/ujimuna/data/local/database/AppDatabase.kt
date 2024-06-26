package com.example.ujimuna.data.local.database

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ujimuna.data.local.dao.DosenDao
import com.example.ujimuna.data.local.dao.ExaminerDao
import com.example.ujimuna.data.local.dao.JadwalDao
import com.example.ujimuna.data.local.dao.MahasiswaDao
import com.example.ujimuna.data.local.entities.Dosen
import com.example.ujimuna.data.local.entities.Examiner
import com.example.ujimuna.data.local.entities.Jadwal
import com.example.ujimuna.data.local.entities.Mahasiswa

@Database(
    entities = [Dosen::class, Examiner::class, Jadwal::class, Mahasiswa::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dosenDao(): DosenDao
    abstract fun examinerDao(): ExaminerDao
    abstract fun jadwalDao(): JadwalDao
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "muna-db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}