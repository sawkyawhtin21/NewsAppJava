package com.skh.roomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.skh.roomdatabase.model.Book

@Dao  // data basae Quary operation .. only one Dao(data access objects)
interface BookDao {
    @Query(value = "Select * from book_table ORDER BY book_name ASC")
    fun getAllBook(): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)   // ignore others
 suspend fun insert(book : Book)
    // put the whole object
  // couritine is backgroun procresss
    @Delete("DELETE")
    suspend fun deleteAll(
        @Query("UPDATE book_table WHERE ")
        // after dao go repository and go viewmodel


    //@Query("SELECT * FROM Users")
    //suspend fun getUsers(): List<User>
    //
    //@Query("SELECT * FROM Users")
    //fun getUsers(): Flow<List<User>>
}