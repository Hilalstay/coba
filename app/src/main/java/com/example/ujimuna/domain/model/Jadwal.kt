package com.example.ujimuna.domain.model

import java.util.Date

data class Jadwal(
    val mahasiswaNim: String,
    val nama: String,
    val tanggal: Date,
    val waktu: String,
    val ruang: String,
    val penguji1: String,
    val penguji2: String,
    val penguji3: String,
    val penguji4: String
)