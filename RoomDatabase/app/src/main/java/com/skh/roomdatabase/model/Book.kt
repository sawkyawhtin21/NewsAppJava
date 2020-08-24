package com.skh.roomdatabase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity  (tableName = "book_table")// get set values
// generate data class for Table
class Book (
@PrimaryKey
@ColumnInfo(name = "id")
var bookID: Int,

@ColumnInfo(name = "book_name")
// database name Bok_name
var boookName: String

)