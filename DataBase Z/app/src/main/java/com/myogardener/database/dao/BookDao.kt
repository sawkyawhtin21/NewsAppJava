package com.myogardener.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myogardener.database.model.Book      //table ေတြ အကုန္လံုးကို  Dao ထဲကပဲလုပ္မယ္

@Dao
interface BookDao {

    @Query(value = "Select * from table_book ORDER BY book_name ASC ")
    fun getAllBook():LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)         //တူတာ၂ခု ရွိရင္ error မတက္ေအာင္
  suspend  fun saveBook(book: Book)

    @Query("delete From table_book")
    suspend fun deleteAll()

    @Query("delete From table_book WHERE book_name=:name")
    suspend fun deleteItem(name:String)

    @Query("UPDATE table_book SET book_name=:updateName WHERE book_name=:name")
    suspend fun updateItem(updateName:String ,name: String)
}