package com.example.cepcoroutines.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.cepcoroutines.data.CepRepository
import com.example.cepcoroutines.model.Cep
import com.example.cepcoroutines.ui.registration.CepViewParams
import com.example.cepcoroutines.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CepViewModel(private val repository: CepRepository): ViewModel() {
    fun getAddress(cep: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getAddress(cep)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
    fun saveCep(cep: Cep) {
        viewModelScope.launch {
            val cepViewParams = CepViewParams()
            cepViewParams.cep = cep.cep
            cepViewParams.logradouro = cep.logradouro
            cepViewParams.complemento = cep.complemento
            cepViewParams.bairro = cep.bairro
            cepViewParams.localidade = cep.localidade
            cepViewParams.uf = cep.uf
            cepViewParams.ibge = cep.ibge
            cepViewParams.gia = cep.gia
            repository.setCep(cepViewParams)
        }

    }

}