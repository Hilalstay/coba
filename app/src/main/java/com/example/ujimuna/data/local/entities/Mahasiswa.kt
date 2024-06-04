package com.example.ujimuna.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mahasiswa")
data class Mahasiswa(
    @PrimaryKey val nim: String,
    val nama: String,
    val semester: Int,
    val sksLulus: Int,
    val judulSkripsi: String,
    val fileSkripsi: Boolean,
    val krs: Boolean,
    val buktiPembayaran: Boolean,
    val pasFoto: Boolean
)