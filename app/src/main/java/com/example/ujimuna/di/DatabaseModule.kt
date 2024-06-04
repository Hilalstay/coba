package com.example.ujimuna.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ujimuna.data.local.database.AppDatabase
import com.example.ujimuna.data.local.entities.Dosen
import com.example.ujimuna.data.local.entities.Examiner
import com.example.ujimuna.data.local.entities.Jadwal
import com.example.ujimuna.data.local.entities.Mahasiswa
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "muna_database"
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    populateDatabase(context.applicationContext, getDatabase(context.applicationContext))
                }
            }
        }).build()
    }

    private suspend fun populateDatabase(context: Context, database: AppDatabase) {
        val mahasiswaDao = database.mahasiswaDao()
        val dosenDao = database.dosenDao()
        val jadwalDao = database.jadwalDao()
        val examinerDao = database.examinerDao()

        // Dummy data for Mahasiswa
        val mahasiswaList = listOf(
            Mahasiswa("123456", "John Doe", 4, 120, "Thesis", true, true, true, true),
            Mahasiswa("789012", "Jane Smith", 5, 130, "Final Project", true, true, true, true)
        )
        mahasiswaDao.insertAll(mahasiswaList)

        // Dummy data for Dosen
        val dosenList = listOf(
            Dosen("001", "Dr. Smith", "Engineering", "Computer Science"),
            Dosen("002", "Prof. Johnson", "Science", "Physics")
        )
        dosenDao.insertAll(dosenList)

        // Dummy data for Jadwal
        val jadwalList = listOf(
            Jadwal(0, "123456", Date(), "09:00", "Room A", "Dr. Smith", "Prof. Johnson", "Prof. Lee", "Dr. Brown"),
            Jadwal(0, "789012", Date(), "10:00", "Room B", "Dr. Smith", "Prof. Johnson", "Prof. Lee", "Dr. Brown")
        )
        jadwalDao.insertAll(jadwalList)

        // Dummy data for Examiner
        val examinerList = listOf(
            Examiner(0, "123456", "001", "approved"),
            Examiner(0, "789012", "002", "reschedule")
        )
        examinerDao.insertAll(examinerList)
    }
}