package com.skh.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skh.roomdatabase.database.BookDatabase
import com.skh.roomdatabase.model.Book
import com.skh.roomdatabase.repository.BookRepository
import kotlinx.coroutines.launch

class BookViewmodel(application: Application): AndroidViewModel(application) {
    private val repository: BookRepository
    val allBook: LiveData<List<Book>>
    init{
        val bookDao = BookDatabase.getDatabase(
            application) . bookDao()
        repository = BookRepository(bookDao)    // repository build object
        allBook = repository.allBook
    }
 suspend fun insert(book: Book) = viewModelScope.launch {
     repository.insert(book)
 }
}