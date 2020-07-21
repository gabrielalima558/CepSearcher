package com.example.cepcoroutines.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cepcoroutines.ui.registration.CepViewParams

@Entity()
data class CepEntity(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val unidade: String,
    val ibge: String,
    val gia: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)


fun CepViewParams.toCepEntity(): CepEntity {
    return with(this) {
        CepEntity(
            cep = this.cep,
            logradouro = this.logradouro,
            bairro = this.bairro,
            localidade = this.localidade,
            complemento = this.complemento,
            uf = this.uf,
            unidade = this.unidade,
            ibge = this.ibge,
            gia = this.gia
        )
    }
}