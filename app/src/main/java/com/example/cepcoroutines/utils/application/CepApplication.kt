package com.example.cepcoroutines.utils.application

import android.app.Application

class CepApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private lateinit var instance: CepApplication

        fun getInstance() =
            instance
    }
}