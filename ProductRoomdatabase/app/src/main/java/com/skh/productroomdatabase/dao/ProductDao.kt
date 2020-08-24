package com.skh.productroomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.skh.productroomdatabase.model.Product

@Dao
interface ProductDao {
    @Query(value = "Select * from table_product ORDER BY product_name ASC ")
    fun getAllBook(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)         //တူတာ၂ခု ရွိရင္ error မတက္ေအာင္
    suspend  fun saveProduct(product: Product)

    @Query("delete From table_product")
    suspend fun deleteAll()

    @Query("delete From table_product WHERE product_name =:name")
    suspend fun deleteItem(name:String)

    @Query("UPDATE table_product SET product_name=:updateName WHERE product_name=:name")
    suspend fun updateItem(updateName:String ,name: String)
}