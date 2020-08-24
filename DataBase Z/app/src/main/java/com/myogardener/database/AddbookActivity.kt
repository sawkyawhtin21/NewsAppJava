package com.myogardener.database

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_addbook.*
import kotlinx.android.synthetic.main.activity_main.*

class AddbookActivity : AppCompatActivity() {

    lateinit var bookName:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addbook)

        btn_save.setOnClickListener{
            val replyIntent=Intent()
            bookName=edt_bookname.text.toString()

        if (TextUtils.isEmpty(edt_bookname.text)){
            setResult(Activity.RESULT_CANCELED,replyIntent)
        }else{
            bookName=edt_bookname.text.toString()
            replyIntent.putExtra(EXTRA_REPLY,bookName)
            setResult(Activity.RESULT_OK,replyIntent)
        }
            finish()
    }


    }
    companion object{
        const val EXTRA_REPLY="REPLY_BOOK"
    }
}