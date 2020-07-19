package com.example.cepcoroutines.api

import retrofit2.Retrofit

class CepApi(private val retrofit: Retrofit) {
    private val service: CepService by lazy {
        retrofit.create(CepService::class.java)
    }
    suspend fun getAddress(cep: String) = service.getAddress(cep)

}