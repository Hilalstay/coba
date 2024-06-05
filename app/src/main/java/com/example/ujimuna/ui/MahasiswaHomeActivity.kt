package com.example.ujimuna.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.ujimuna.R
import com.example.ujimuna.data.local.dao.JadwalDao
import com.example.ujimuna.data.local.dao.MahasiswaDao
import com.example.ujimuna.data.local.database.AppDatabase


class MahasiswaHomeActivity : AppCompatActivity() {
    private lateinit var imgProfile: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvNim: TextView
    private lateinit var layoutJadwal: LinearLayout
    private lateinit var layoutJadwalDetails: LinearLayout
    private lateinit var tvWaitingMessage: TextView
    private lateinit var db: AppDatabase
    private lateinit var jadwalDao: JadwalDao
    private lateinit var mahasiswaDao: MahasiswaDao
    private lateinit var nim: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahasiswa_home)

        imgProfile = findViewById(R.id.img_profile)
        tvName = findViewById(R.id.tv_name)
        tvNim = findViewById(R.id.tv_nim)
        layoutJadwal = findViewById(R.id.layout_jadwal)
        layoutJadwalDetails = findViewById(R.id.layout_jadwal_details)
        tvWaitingMessage = findViewById(R.id.tv_waiting_message)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "muna-db"
        ).allowMainThreadQueries().build()

        jadwalDao = db.jadwalDao()
        mahasiswaDao = db.mahasiswaDao()

        nim = intent.getStringExtra("nim") ?: ""
        val mahasiswa = mahasiswaDao.getByNIM(nim)

        if (mahasiswa != null) {
            tvName.text = mahasiswa.nama
            tvNim.text = mahasiswa.nim
        }

        loadJadwal()
    }

    private fun loadJadwal() {
        val jadwal = jadwalDao.getByMahasiswaNim(nim)

        if (jadwal != null) {
            // Populate jadwal fields and make layout visible
            layoutJadwalDetails.visibility = View.VISIBLE
            tvWaitingMessage.visibility = View.GONE
            // Update jadwal details fields
            findViewById<TextView>(R.id.tv_jadwal_nim).text = jadwal.mahasiswaNim
            findViewById<TextView>(R.id.tv_jadwal_name).text = mahasiswaDao.getByNIM(jadwal.mahasiswaNim)?.nama
            findViewById<TextView>(R.id.tv_jadwal_semester).text = mahasiswaDao.getByNIM(jadwal.mahasiswaNim)?.semester.toString()
            findViewById<TextView>(R.id.tv_jadwal_sks).text = mahasiswaDao.getByNIM(jadwal.mahasiswaNim)?.sksLulus.toString()
            findViewById<TextView>(R.id.tv_jadwal_title).text = mahasiswaDao.getByNIM(jadwal.mahasiswaNim)?.judulSkripsi
            findViewById<TextView>(R.id.tv_jadwal_date).text = jadwal.tanggal.toString()
            findViewById<TextView>(R.id.tv_jadwal_time).text = jadwal.waktu
            findViewById<TextView>(R.id.tv_jadwal_location).text = jadwal.ruang
            findViewById<TextView>(R.id.tv_jadwal_examiner1).text = jadwal.penguji1
            findViewById<TextView>(R.id.tv_jadwal_examiner2).text = jadwal.penguji2
            findViewById<TextView>(R.id.tv_jadwal_examiner3).text = jadwal.penguji3
            findViewById<TextView>(R.id.tv_jadwal_examiner4).text = jadwal.penguji4
        } else {
            // Show waiting message
            layoutJadwalDetails.visibility = View.GONE
            tvWaitingMessage.visibility = View.VISIBLE
        }
    }
}
