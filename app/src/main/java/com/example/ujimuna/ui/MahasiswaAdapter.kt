package com.example.ujimuna.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ujimuna.R
import com.example.ujimuna.data.local.entities.Examiner
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MahasiswaAdapter(private val examiners: List<Examiner>) : RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val examiner = examiners[position]
        holder.tvNim.text = examiner.studentNim
        holder.tvName.text = examiner.studentName // Assuming you have a field for student name
        holder.tvTitle.text = examiner.studentTitle // Assuming you have a field for student title
        holder.tvDate.text = examiner.date
        holder.tvTime.text = examiner.time
        holder.tvLocation.text = examiner.location

        holder.btnApprove.setOnClickListener {
            // Handle approval logic
        }

        holder.btnReschedule.setOnClickListener {
            // Handle rescheduling logic
        }
    }


    override fun getItemCount(): Int {
        return examiners.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNim: TextView = itemView.findViewById(R.id.tv_nim)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvDate: TextView = itemView.findViewById(R.id.tv_date)
        val tvTime: TextView = itemView.findViewById(R.id.tv_time)
        val tvLocation: TextView = itemView.findViewById(R.id.tv_location)
        val btnApprove: Button = itemView.findViewById(R.id.btn_approve)
        val btnReschedule: Button = itemView.findViewById(R.id.btn_reschedule)
    }
    private fun approveSchedule(examiner: Examiner) {
        // Approval logic
        Toast.makeText(context, "Jadwal disetujui", Toast.LENGTH_SHORT).show()
    }

    private fun rescheduleSchedule(examiner: Examiner) {
        // Open reschedule dialog
        val dialog = RescheduleDialogFragment(examiner)
        dialog.show((context as AppCompatActivity).supportFragmentManager, "RescheduleDialog")
    }
}
