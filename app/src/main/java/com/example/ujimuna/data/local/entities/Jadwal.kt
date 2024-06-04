package com.example.ujimuna.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "jadwal")
data class Jadwal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val mahasiswaNim: String,
    val tanggal: Date,
    val waktu: String,
    val ruang: String,
    val penguji1: String,
    val penguji2: String,
    val penguji3: String,
    val penguji4: String
)