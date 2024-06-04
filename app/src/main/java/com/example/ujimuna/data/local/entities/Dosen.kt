package com.example.ujimuna.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dosen")
data class Dosen(
    @PrimaryKey val nip: String,
    val nama: String,
    val unitKerja: String,
    val konsorsiumIlmu: String
)