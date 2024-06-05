package com.example.ujimuna.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "examiner")
data class Examiner(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val studentNim: String,
    val studentName: String,
    val studentTitle : String,
    val date: String,
    var time: String,
    val location: String,
    val examiner1Nip: String,
    val examiner2Nip: String,
    val examiner3Nip: String,
    val examiner4Nip: String
)