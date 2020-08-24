package com.skh.productroomdatabase.repository

import androidx.lifecycle.LiveData
import com.skh.productroomdatabase.dao.ProductDao
import com.skh.productroomdatabase.model.Product

class ProductRepository (private val productDao: ProductDao){            //ၾကားခံသံုးဖို႕ repository  ေဆာက္
    //DAO ဘက္က ေကာင္ေတြကို ေခၚ

    val allProduct: LiveData<List<Product>> =productDao.getAllBook()
    suspend  fun productInsert(product: Product){
        productDao.saveProduct(product)
    }

    suspend  fun delete() {
        productDao.deleteAll()
    }

    suspend fun deleteItem(name:String){
        productDao.deleteItem(name)
    }

    suspend fun updateItem(updateName:String,name: String){
        productDao.updateItem(updateName,name)
    }

}