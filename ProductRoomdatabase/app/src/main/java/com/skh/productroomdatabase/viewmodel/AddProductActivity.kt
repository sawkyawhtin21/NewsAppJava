package com.skh.productroomdatabase.viewmodel

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.skh.productroomdatabase.R
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductActivity : AppCompatActivity() {
    lateinit var productkName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        btn_save.setOnClickListener {
            val replyIntent = Intent()
            productkName = edt_name.text.toString()

            if (TextUtils.isEmpty(edt_name.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                productkName = edt_name.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, productkName )
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "REPLY_PRODUCT"
    }
}