package com.example.ujimuna.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ujimuna.R
import com.example.ujimuna.presentation.MahasiswaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MahasiswaFragment : Fragment() {

    private val mahasiswaViewModel: MahasiswaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mahasiswa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe data and update UI
        mahasiswaViewModel.mahasiswa.observe(viewLifecycleOwner, { mahasiswa ->
            // Update UI with mahasiswa data
        })

        // Fetch mahasiswa data
        val nim = arguments?.getString("NIM")
        if (nim != null) {
            mahasiswaViewModel.fetchMahasiswa(nim)
        }
    }
}