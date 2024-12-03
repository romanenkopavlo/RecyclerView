package com.michael.rv_2024.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.michael.rv_2024.retrofit.ApiAdapteur
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel : ViewModel() {
    private val _data = MutableLiveData<ArrayList<Etudiant>>()
    val data: LiveData<ArrayList<Etudiant>> get() = _data

    fun initData() {
        val initialData = arrayListOf<Etudiant>()
        _data.value = initialData
    }

    fun updateData(data: ArrayList<Etudiant>) {
        _data.value = data
    }

}