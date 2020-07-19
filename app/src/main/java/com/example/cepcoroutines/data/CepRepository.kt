package com.example.cepcoroutines.data

import com.example.cepcoroutines.api.CepApi

class CepRepository(private val api: CepApi) {

    suspend fun getAddress(cep: String) = api.getAddress(cep)

}