package com.skh.productroomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.skh.productroomdatabase.database.ProductDatabase
import com.skh.productroomdatabase.model.Product
import com.skh.productroomdatabase.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: ProductRepository
    val allproduct: LiveData<List<Product>>

    init {
        val productDB= ProductDatabase.getDatabase(application).productDao()

        repository= ProductRepository(productDB)
        allproduct = repository.allProduct
    }
    fun insert (product: Product) = viewModelScope.launch {
        repository.productInsert(product)
    }
    fun delete() = viewModelScope.launch {
        repository.delete()
    }
        fun deleteItem (name:String)= viewModelScope.launch {
            repository.deleteItem(name)
        }
        fun updateItem(updateName:String, name:String) = viewModelScope.launch {
            repository.updateItem(updateName, name)
        }

}