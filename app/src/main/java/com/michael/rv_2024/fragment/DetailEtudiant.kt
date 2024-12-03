package com.michael.rv_2024.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.michael.rv_2024.R
import com.michael.rv_2024.databinding.FragmentDetailEtudiantBinding
import com.michael.rv_2024.models.DataViewModel
import com.michael.rv_2024.models.DataViewModelDetail


class DetailEtudiant : Fragment() {
    private lateinit var binding: FragmentDetailEtudiantBinding
    private lateinit var viewModelPartageDetail: DataViewModelDetail

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?): View? {
        viewModelPartageDetail = ViewModelProvider(requireActivity()).get(DataViewModelDetail::class.java)
        binding = FragmentDetailEtudiantBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@DetailEtudiant
        binding.etudiant = viewModelPartageDetail
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}