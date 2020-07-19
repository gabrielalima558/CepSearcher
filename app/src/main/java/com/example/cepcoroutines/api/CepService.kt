package com.example.cepcoroutines.api

import com.example.cepcoroutines.model.Cep
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {

    @GET("/ws/{cep}/json/")
    suspend fun getAddress(@Path("cep") cep: String): Cep
}