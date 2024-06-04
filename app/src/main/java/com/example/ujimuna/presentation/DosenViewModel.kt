package com.example.ujimuna.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ujimuna.data.local.entities.Dosen
import com.example.ujimuna.domain.usecase.GetApprovedStudentsByDosenUseCase
import com.example.ujimuna.domain.usecase.GetDosenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DosenViewModel @Inject constructor(
    private val getDosenUseCase: GetDosenUseCase
) : ViewModel() {

    private val _dosen = MutableLiveData<Dosen>()
    val dosen: LiveData<Dosen> get() = _dosen

    fun fetchDosen(nip: String) {
        viewModelScope.launch {
            _dosen.value = getDosenUseCase.execute(nip)
        }
    }
}