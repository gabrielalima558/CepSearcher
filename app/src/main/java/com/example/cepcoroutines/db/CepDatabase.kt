package com.example.cepcoroutines.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cepcoroutines.model.CepEntity

@Database(entities = [CepEntity::class], version = 2)
abstract class CepDatabase : RoomDatabase() {

    abstract fun cepDao(): CepDao

    companion object {
        private var database: CepDatabase? = null

        private val DATABASE = "DeliveryDB"

        fun getInstance(context: Context): CepDatabase {
            return database ?: createDB(context).also {
                database = it
            }
        }

        private fun createDB(context: Context): CepDatabase {
            return Room.databaseBuilder(context, CepDatabase::class.java, DATABASE)
                .allowMainThreadQueries()
                .build()
        }
    }
}