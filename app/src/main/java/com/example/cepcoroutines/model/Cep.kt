package com.example.cepcoroutines.model

data class Cep(val cep: String,
               val logradouro: String,
               val complemento: String,
               val bairro: String,
               val localidade: String,
               val uf: String,
               val unidade: String,
               val ibge: String,
               val gia: String
               )