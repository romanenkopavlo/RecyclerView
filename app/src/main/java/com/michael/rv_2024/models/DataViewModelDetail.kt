package com.michael.rv_2024.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModelDetail: ViewModel() {
    private val _data = MutableLiveData<Etudiant>()
    private val data: LiveData<Etudiant> = _data

    @SuppressLint("NullSafeMutableLiveData")
    fun initData() {
        _data.value = null
    }

    fun updateData(data: Etudiant) {
        _data.value = data
    }

    fun getData() : LiveData<Etudiant> = _data
}