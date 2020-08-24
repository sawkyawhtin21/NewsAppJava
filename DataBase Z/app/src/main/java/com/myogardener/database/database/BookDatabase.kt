package com.myogardener.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myogardener.database.dao.BookDao
import com.myogardener.database.model.Book

import kotlinx.coroutines.internal.synchronized

@Database (entities = [(Book::class)],version =1)
abstract class BookDatabase :RoomDatabase(){

        abstract fun bookDao():BookDao

        companion object {                  //

            private var INSTANCE: BookDatabase? = null

            fun getDatabase(context: Context): BookDatabase {        //database ေဆာက္မယ္
                var temInstance = INSTANCE
                if (temInstance != null) {
                    return temInstance
                }

                kotlin.synchronized(this) {
                    val instance =
                        Room.databaseBuilder(context.applicationContext, BookDatabase::class.java, "BookDB").build()
                    INSTANCE = instance
                    return instance
                }

            }
        }
    }


