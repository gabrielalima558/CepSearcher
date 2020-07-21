package com.example.cepcoroutines.data

import com.example.cepcoroutines.api.CepApi
import com.example.cepcoroutines.db.CepDao
import com.example.cepcoroutines.model.toCepEntity
import com.example.cepcoroutines.ui.registration.CepViewParams

class CepRepository(private val api: CepApi,  private val cepDao: CepDao) {

    suspend fun getAddress(cep: String) = api.getAddress(cep)

    fun getCep() = cepDao.listCeps()

    //separação de camadas
    //camada de apresentação vai passar o registrationViewParams
    suspend fun setCep(cepViewParams: CepViewParams){
        //Conversão para a camada de dados
        val cepEntity = cepViewParams.toCepEntity()
        cepDao.insertCep(cepEntity)
    }



}