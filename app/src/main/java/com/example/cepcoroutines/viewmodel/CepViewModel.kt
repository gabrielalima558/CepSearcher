package com.example.cepcoroutines.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.cepcoroutines.data.CepRepository
import com.example.cepcoroutines.utils.Resource
import kotlinx.coroutines.Dispatchers

class CepViewModel(private val repository: CepRepository): ViewModel() {
    fun getAddress(cep: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getAddress(cep)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}