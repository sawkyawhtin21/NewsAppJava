package com.skh.productroomdatabase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_product")
class Product(
    @PrimaryKey  //  if you wnt more delete and add put primarykey
    @ColumnInfo(name = "product_id")
    var productId: String,

    @ColumnInfo(name = "product_name")
    var productName: String,

    @ColumnInfo(name = "product_price")
    var productPrice: String,

    @ColumnInfo(name = "product_qantity")
    var productQantity: Int

)

