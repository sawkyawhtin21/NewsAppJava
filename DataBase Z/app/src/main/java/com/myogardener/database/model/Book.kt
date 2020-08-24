package com.myogardener.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_book")                 //for table
class Book(
    @PrimaryKey
    @ColumnInfo(name = "book_name")
    var bookName:String

)



//    @PrimaryKey
//    @ColumnInfo(name = "id")
//    var bookID:Int,
