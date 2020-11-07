package com.example.cepcoroutines.ui.registration

data class CepViewParams(
    var cep: String = "",
    var logradouro: String = "",
    var complemento: String = "",
    var bairro: String = "",
    var localidade: String = "",
    var uf: String = "",
    var ibge: String = "",
    var gia: String = ""
)