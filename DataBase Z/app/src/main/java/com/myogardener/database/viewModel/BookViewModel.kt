package com.myogardener.database.viewModel

import android.app.Application
import android.util.Log
import androidx.annotation.RestrictTo
import androidx.lifecycle.*
import com.myogardener.database.dao.BookDao
import com.myogardener.database.database.BookDatabase
import com.myogardener.database.model.Book
import com.myogardener.database.repository.BookRepository
import kotlinx.coroutines.launch

class BookViewModel(application: Application): AndroidViewModel(application) {

    private var repositoriy:BookRepository
    val allbook:LiveData<List<Book>>

    init {
        val bookDB= BookDatabase.getDatabase(application).bookDao()

        repositoriy= BookRepository(bookDB)
        allbook=repositoriy.allBook
    }

     fun insert(book: Book)=viewModelScope.launch {
        repositoriy.bookInsert(book)

    }
   fun delete() = viewModelScope.launch {
       repositoriy.delete()
   }
    fun deleteItem(name:String)=viewModelScope.launch {
        repositoriy.deleteItem(name)
    }
    fun updateItem(updateName:String,name: String) = viewModelScope.launch{
        repositoriy.updateItem(updateName,name)
    }

}