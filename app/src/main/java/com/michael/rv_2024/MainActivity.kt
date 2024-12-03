package com.michael.rv_2024

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import com.michael.rv_2024.databinding.ActivityMainBinding
import com.michael.rv_2024.fragment.Main
import com.michael.rv_2024.models.DataViewModel
import com.michael.rv_2024.models.DataViewModelDetail
import com.michael.rv_2024.retrofit.ApiAdapteur
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewmodelPartage: DataViewModel
    lateinit var viewmodelPartageDetail: DataViewModelDetail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodelPartage = ViewModelProvider(this).get(DataViewModel::class.java)
        viewmodelPartageDetail = ViewModelProvider(this).get(DataViewModelDetail::class.java)

        remplaceFragment(binding.fragmentContainer, Main())

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    private fun remplaceFragment(fragmentcccontainer: FragmentContainerView, fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(fragmentcccontainer.id, fragment)
        fragmentTransaction.commit()
    }
}