package com.example.ujimuna.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ujimuna.R
import com.example.ujimuna.domain.model.Mahasiswa

class StudentAdapter(private val students: List<Mahasiswa>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount() = students.size

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(student: Mahasiswa) {
            itemView.student_name.text = student.nama
            itemView.student_nim.text = student.nim
            itemView.student_semester.text = student.semester.toString()
        }
    }
}