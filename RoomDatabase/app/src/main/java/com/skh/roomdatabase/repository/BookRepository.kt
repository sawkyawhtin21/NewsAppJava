package com.skh.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.skh.roomdatabase.dao.BookDao
import com.skh.roomdatabase.model.Book

class BookRepository (private val bookDao: BookDao){    // respository call dao
    val allBook:LiveData<List<Book>>  = bookDao.getAllBook()
 suspend fun Insert(book: Book){
        bookDao.insert(book)
    }
    suspend fun delete() {
        bookDao.deleteAll()
    }
}
// LiveData<List<Book>>