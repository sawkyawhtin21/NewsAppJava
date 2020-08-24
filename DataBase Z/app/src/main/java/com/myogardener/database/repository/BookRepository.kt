package com.myogardener.database.repository

import androidx.lifecycle.LiveData
import com.myogardener.database.dao.BookDao
import com.myogardener.database.model.Book

class BookRepository (private val bookDao: BookDao){            //ၾကားခံသံုးဖို႕ repository  ေဆာက္
                                                                //DAO ဘက္က ေကာင္ေတြကို ေခၚ

    val allBook:LiveData<List<Book>> =bookDao.getAllBook()
  suspend  fun bookInsert(book: Book){
        bookDao.saveBook(book)
    }

  suspend  fun delete() {
        bookDao.deleteAll()
    }

    suspend fun deleteItem(name:String){
        bookDao.deleteItem(name)
    }

    suspend fun updateItem(updateName:String,name: String){
        bookDao.updateItem(updateName,name)
    }

}