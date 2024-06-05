package com.example.ujimuna.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.ujimuna.R
import com.example.ujimuna.data.local.dao.DosenDao
import com.example.ujimuna.data.local.dao.MahasiswaDao
import com.example.ujimuna.data.local.database.AppDatabase

class LoginActivity : AppCompatActivity() {
    private lateinit var etNimNip: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var db: AppDatabase
    private lateinit var mahasiswaDao: MahasiswaDao
    private lateinit var dosenDao: DosenDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etNimNip = findViewById(R.id.et_nim_nip)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        btnRegister = findViewById(R.id.btn_register)

        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "muna-db").allowMainThreadQueries().build()
        mahasiswaDao = db.mahasiswaDao()
        dosenDao = db.dosenDao()

        btnLogin.setOnClickListener { login() }
        btnRegister.setOnClickListener { register() }
    }

    private fun login() {
        val nimNip = etNimNip.text.toString()
        val password = etPassword.text.toString()

        // Logic to check if the user is a student or lecturer
        val mahasiswa = mahasiswaDao.getByNIM(nimNip)
        val dosen = dosenDao.getByNIP(nimNip)

        if (mahasiswa != null && mahasiswa.password == password) {
            // Navigate to Mahasiswa Home
            val intent = Intent(this@LoginActivity, MahasiswaHomeActivity::class.java)
            intent.putExtra("nim", nimNip)
            startActivity(intent)
        } else if (dosen != null && dosen.password == password) {
            // Navigate to Dosen Home
            val intent = Intent(this@LoginActivity, DosenHomeActivity::class.java)
            intent.putExtra("nip", nimNip)
            startActivity(intent)
        } else {
            Toast.makeText(this, "NIM/NIP atau Password salah", Toast.LENGTH_SHORT).show()
        }
    }

    private fun register() {
        val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
        startActivity(intent)
    }
}
