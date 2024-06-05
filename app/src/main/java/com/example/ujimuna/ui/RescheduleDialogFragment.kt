package com.example.ujimuna.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.ujimuna.R
import com.example.ujimuna.data.local.entities.Examiner

class RescheduleDialogFragment(private val examiner: Examiner) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.dialog_reschedule, null)

            val etDate = view.findViewById<EditText>(R.id.et_date)
            val etTime = view.findViewById<EditText>(R.id.et_time)
            val etLocation = view.findViewById<EditText>(R.id.et_location)

            builder.setView(view)
                .setPositiveButton("Reschedule") { _, _ ->
                    // Reschedule logic
                    val newDate = etDate.text.toString()
                    val newTime = etTime.text.toString()
                    val newLocation = etLocation.text.toString()

                    if (newDate.isNotEmpty() && newTime.isNotEmpty() && newLocation.isNotEmpty()) {
                        // Update the schedule in the database
                        examiner.date = newDate
                        examiner.time = newTime
                        examiner.location = newLocation
                        Toast.makeText(activity, "Jadwal direschedule", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(activity, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                    }
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
