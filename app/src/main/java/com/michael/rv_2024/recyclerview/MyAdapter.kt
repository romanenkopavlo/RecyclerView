package com.michael.rv_2024.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.michael.rv_2024.databinding.ItemEtudiantsBinding
import com.michael.rv_2024.models.Etudiant

class MyAdapter(private val lesEtudiants: ArrayList<Etudiant>, private val onItemClick:(Etudiant) -> Unit): RecyclerView.Adapter<MyHolder>() {
    private lateinit var binding: ItemEtudiantsBinding
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyHolder {
        binding = ItemEtudiantsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(lesEtudiants.get(position))
        holder.itemView.setOnClickListener {
            onItemClick(lesEtudiants.get(position))
        }
    }

    override fun getItemCount(): Int {
        return lesEtudiants.size
    }

}