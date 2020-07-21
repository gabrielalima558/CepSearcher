package com.example.deliverytest.application

import com.example.cepcoroutines.db.CepDatabase
import com.example.cepcoroutines.utils.application.CepApplication


object Injector {

    private val context = CepApplication.getInstance()

    private val database =
        CepDatabase.getInstance(
            context
        )

    fun cepDao() = database.cepDao()


}