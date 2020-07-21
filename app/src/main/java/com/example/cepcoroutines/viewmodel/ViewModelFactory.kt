package com.example.cepcoroutines.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cepcoroutines.api.CepApi
import com.example.cepcoroutines.api.RetrofitBuilder
import com.example.cepcoroutines.data.CepRepository
import com.example.deliverytest.application.Injector


object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private val retrofit = RetrofitBuilder.retrofit

    private val cepApi = CepApi(retrofit)

    private val cepRepository =
        CepRepository(cepApi, Injector.cepDao())

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return CepViewModel(cepRepository) as T

    }
}