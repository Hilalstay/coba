package com.example.ujimuna.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.ujimuna.R
import com.example.ujimuna.data.local.entities.Mahasiswa
import com.example.ujimuna.presentation.MahasiswaViewModel
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private lateinit var etNimSearch: EditText
    private lateinit var btnSearch: Button
    private lateinit var btnSiapSkripsi: Button
    private lateinit var tvName: TextView
    private lateinit var tvSemester: TextView
    private lateinit var tvSks: TextView
    private lateinit var tvJudulSkripsi: TextView
    private lateinit var imgFileSkripsi: ImageView
    private lateinit var imgKrs: ImageView
    private lateinit var imgBuktiPembayaran: ImageView
    private lateinit var imgPasFoto: ImageView
    private lateinit var mahasiswaViewModel: MahasiswaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etNimSearch = findViewById(R.id.et_nim_search)
        btnSearch = findViewById(R.id.btn_search)
        btnSiapSkripsi = findViewById(R.id.btn_siap_skripsi)
        tvName = findViewById(R.id.tv_name)
        tvSemester = findViewById(R.id.tv_semester)
        tvSks = findViewById(R.id.tv_sks)
        tvJudulSkripsi = findViewById(R.id.tv_judul_skripsi)
        imgFileSkripsi = findViewById(R.id.img_file_skripsi)
        imgKrs = findViewById(R.id.img_krs)
        imgBuktiPembayaran = findViewById(R.id.img_bukti_pembayaran)
        imgPasFoto = findViewById(R.id.img_pas_foto)

        mahasiswaViewModel = ViewModelProvider(this).get(MahasiswaViewModel::class.java)

        btnSearch.setOnClickListener {
            val nim = etNimSearch.text.toString()
            if (nim.isNotEmpty()) {
                searchMahasiswa(nim)
            } else {
                Toast.makeText(this, "NIM tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }

        btnSiapSkripsi.setOnClickListener {
            Toast.makeText(this, "Anda siap untuk skripsi", Toast.LENGTH_SHORT).show()
        }
    }

    private fun searchMahasiswa(nim: String) {
        lifecycleScope.launch {
            val mahasiswa = mahasiswaViewModel.getMahasiswaByNIM(nim)
            if (mahasiswa != null) {
                updateMahasiswaInfo(mahasiswa)
                btnSiapSkripsi.visibility = View.VISIBLE
            } else {
                Toast.makeText(this@RegisterActivity, "Anda belum terdaftar dalam pengujian skripsi munaqosah", Toast.LENGTH_LONG).show()
                clearMahasiswaInfo()
                btnSiapSkripsi.visibility = View.GONE
            }
        }
    }

    private fun updateMahasiswaInfo(mahasiswa: Mahasiswa) {
        tvName.text = mahasiswa.nama
        tvSemester.text = mahasiswa.semester.toString()
        tvSks.text = mahasiswa.sksLulus.toString()
        tvJudulSkripsi.text = mahasiswa.judulSkripsi

        updateFileStatus(imgFileSkripsi, mahasiswa.fileSkripsi)
        updateFileStatus(imgKrs, mahasiswa.krs)
        updateFileStatus(imgBuktiPembayaran, mahasiswa.buktiPembayaran)
        updateFileStatus(imgPasFoto, mahasiswa.pasFoto)

        tvName.visibility = View.VISIBLE
        tvSemester.visibility = View.VISIBLE
        tvSks.visibility = View.VISIBLE
        tvJudulSkripsi.visibility = View.VISIBLE
        imgFileSkripsi.visibility = View.VISIBLE
        imgKrs.visibility = View.VISIBLE
        imgBuktiPembayaran.visibility = View.VISIBLE
        imgPasFoto.visibility = View.VISIBLE
    }

    private fun clearMahasiswaInfo() {
        tvName.text = ""
        tvSemester.text = ""
        tvSks.text = ""
        tvJudulSkripsi.text = ""
        imgFileSkripsi.setImageResource(0)
        imgKrs.setImageResource(0)
        imgBuktiPembayaran.setImageResource(0)
        imgPasFoto.setImageResource(0)
        tvName.visibility = View.GONE
        tvSemester.visibility = View.GONE
        tvSks.visibility = View.GONE
        tvJudulSkripsi.visibility = View.GONE
        imgFileSkripsi.visibility = View.GONE
        imgKrs.visibility = View.GONE
        imgBuktiPembayaran.visibility = View.GONE
        imgPasFoto.visibility = View.GONE
    }

    private fun updateFileStatus(imageView: ImageView, isComplete: Boolean) {
        if (isComplete) {
            imageView.setImageResource(R.drawable.approve_icon)
        } else {
            imageView.setImageResource(R.drawable.cross_icon)
        }
    }
}