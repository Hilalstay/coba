package com.example.ujimuna.di

import android.content.Context
import androidx.room.Room
import com.example.ujimuna.data.local.database.AppDatabase
import com.example.ujimuna.data.remote.remote_data_source.ApiService
import com.example.ujimuna.data.repository.DosenRepository
import com.example.ujimuna.data.repository.ExaminerRepository
import com.example.ujimuna.data.repository.JadwalRepository
import com.example.ujimuna.data.repository.MahasiswaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "muna_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDosenRepository(db: AppDatabase): DosenRepository {
        return DosenRepository(db.dosenDao())
    }

    @Provides
    @Singleton
    fun provideExaminerRepository(db: AppDatabase): ExaminerRepository {
        return ExaminerRepository(db.examinerDao())
    }

    @Provides
    @Singleton
    fun provideJadwalRepository(db: AppDatabase): JadwalRepository {
        return JadwalRepository(db.jadwalDao())
    }

    @Provides
    @Singleton
    fun provideMahasiswaRepository(db: AppDatabase): MahasiswaRepository {
        return MahasiswaRepository(db.mahasiswaDao())
    }
}