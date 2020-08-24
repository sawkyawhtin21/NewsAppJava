package com.skh.roomdatabase.database

import android.content.Context
import android.provider.CalendarContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.skh.roomdatabase.dao.BookDao
import com.skh.roomdatabase.model.Book


@Database(entities = arrayOf(Book::class), version = 1) // entities is table call
abstract  class BookDatabase :  RoomDatabase(){

    abstract fun bookDao(): BookDao

    companion object{
        private var INSTANCE: BookDatabase? = null

        fun getDatabase(context: Context): BookDatabase{
            val temInstance= INSTANCE
            if (temInstance != null){
                return  temInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,BookDatabase::class.java,"book_database").build()
                 INSTANCE=instance
                return instance
            }
        }
    }
}