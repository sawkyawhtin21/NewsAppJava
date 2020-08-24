package com.skh.productroomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.skh.productroomdatabase.dao.ProductDao
import com.skh.productroomdatabase.model.Product

@Database(entities = [(Product::class)],version =1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {                  //

        private var INSTANCE: ProductDatabase? = null
        fun getDatabase(context: Context): ProductDatabase {        //database ေဆာက္မယ္
            var temInstance = INSTANCE
            if (temInstance != null) {
                return temInstance
            }
            kotlin.synchronized(this){
            val instance =
           Room.databaseBuilder(context.applicationContext, ProductDatabase:: class.java, "ProductDB").build()
           INSTANCE = instance
                return instance
            }

        }
    }
}