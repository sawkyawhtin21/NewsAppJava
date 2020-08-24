package com.skh.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_book.*

class AddBookActivity : AppCompatActivity() {
    lateinit var bookName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)



        btnSave.setOnClickListener{
            bookName = edtBookName.text.toString()
        }

    }
}