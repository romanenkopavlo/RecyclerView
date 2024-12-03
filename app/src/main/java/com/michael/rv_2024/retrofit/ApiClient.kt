package com.michael.rv_2024.retrofit


import com.michael.rv_2024.models.Etudiant
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("01f7fecc-a8f1-4c30-9f56-e95f4c47183c")
    suspend fun getTousLesEtudiantsEtudiants(): Response<ArrayList<Etudiant>>
}