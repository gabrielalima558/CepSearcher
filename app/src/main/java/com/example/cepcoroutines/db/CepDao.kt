package com.example.cepcoroutines.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cepcoroutines.model.CepEntity

@Dao
interface CepDao {
    @Insert
    suspend fun insertCep(cep: CepEntity)

    @Query("select * from CepEntity")
    fun listCeps() : LiveData<CepEntity>
}