package com.michael.rv_2024.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.michael.rv_2024.R
import com.michael.rv_2024.databinding.FragmentMainBinding
import com.michael.rv_2024.models.DataViewModel
import com.michael.rv_2024.models.DataViewModelDetail
import com.michael.rv_2024.recyclerview.MyAdapter
import com.michael.rv_2024.retrofit.ApiAdapteur
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Main : Fragment(R.layout.fragment_main) {
    private lateinit var binding : FragmentMainBinding
    private lateinit var viewModelPartage : DataViewModel
    private lateinit var viewModelPartageDetail: DataViewModelDetail

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModelPartage = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        viewModelPartageDetail = ViewModelProvider(requireActivity()).get(DataViewModelDetail::class.java)
        binding = FragmentMainBinding.inflate(inflater,container,false)
        miseAJour()
        return binding.root
    }

    private fun miseAJour() {
        GlobalScope.launch(Dispatchers.Main) {
            val response = ApiAdapteur.apiClient.getTousLesEtudiantsEtudiants()
            if (response.isSuccessful) {
                response.body()?.let {arrayListEtudiants ->
                    viewModelPartage.updateData(arrayListEtudiants)
                    binding.rvStudents.adapter = MyAdapter(viewModelPartage.data.value!!) {
                        viewModelPartageDetail.updateData(it)
                        afficherDetails()
                    }
                    binding.rvStudents.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                }
            }
        }
    }

    private fun afficherDetails() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, DetailEtudiant())
            .addToBackStack(null)
            .commit()
    }
}