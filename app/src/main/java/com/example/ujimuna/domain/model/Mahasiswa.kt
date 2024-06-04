package com.example.ujimuna.domain.model

data class Mahasiswa(
    val nim: String,
    val nama: String,
    val semester: Int,
    val sksLulus: Int,
    val judulSkripsi: String,
    val fileSkripsi: Boolean,
    val krs: Boolean,
    val buktiPembayaran: Boolean,
    val pasFoto: Boolean
)