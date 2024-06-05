package com.example.ujimuna.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.ujimuna.R
import com.example.ujimuna.data.local.dao.DosenDao
import com.example.ujimuna.data.local.dao.ExaminerDao
import com.example.ujimuna.data.local.database.AppDatabase


class DosenHomeActivity : AppCompatActivity() {
    private lateinit var imgProfile: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvNip: TextView
    private lateinit var rvMahasiswa: RecyclerView
    private lateinit var db: AppDatabase
    private lateinit var examinerDao: ExaminerDao
    private lateinit var dosenDao: DosenDao
    private lateinit var nip: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dosen_home)

        imgProfile = findViewById(R.id.img_profile)
        tvName = findViewById(R.id.tv_name)
        tvNip = findViewById(R.id.tv_nip)
        rvMahasiswa = findViewById(R.id.rv_mahasiswa)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "muna-db"
        ).allowMainThreadQueries().build()

        examinerDao = db.examinerDao()
        dosenDao = db.dosenDao()

        nip = intent.getStringExtra("nip") ?: ""
        val dosen = dosenDao.getByNIP(nip)

        if (dosen != null) {
            tvName.text = dosen.nama
            tvNip.text = dosen.nip
        }

        loadMahasiswa()
    }

    private fun loadMahasiswa() {
        val examiners = examinerDao.getByMahasiswaNim(nip)
        rvMahasiswa.layoutManager = LinearLayoutManager(this)
        rvMahasiswa.adapter = MahasiswaAdapter(examiners)
    }
}
