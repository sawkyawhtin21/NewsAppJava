package com.skh.roomdatabase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.skh.roomdatabase.adapter.BookAdapter
import com.skh.roomdatabase.database.BookDatabase
import com.skh.roomdatabase.model.Book
import com.skh.roomdatabase.viewmodel.BookViewmodel
import kotlinx.android.synthetic.main.activity_add_book.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var bookViewmodel: BookViewmodel
    private lateinit var bookAdapter: BookAdapter
    private val addBookActivityRequestCode = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 bookViewmodel = ViewModelProviders(this).get(BookViewmodel::class.java)
        recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookAdapter

        } bookViewModel . allbook . observe (
                this, Observer{ book ->
            book.Let {
                bookAdapter.addBookList(book)
            }
        }
        )
        btnDelete.setOnClickListener{}

        btnAdd.setOnClickListener {
            bookName = edtBookName.text.toString()
            val replyIntent
            if (TextUtils.isEmpty(edtBookName.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)

            } else {
                bookName = edtBookName.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, bookName)
                setResult((Activity.RESULT_OK, replyIntent))
            }
//            val intent = Intent(
//                this,
//                AddBookActivity::class.java

            //     startActivity
            startActivityForResult(intent, addBookActivityRequestCode)
        }
    }
}

companion object {
    const val EXTRA_REPLY = "REPLY BOOK"
}


/*      Thread {
    val db = Room.databaseBuilder( // val db is build database object
        applicationContext,
        BookDatabase::class.java,
        "BookDB"
    ).build()
  val book = Book(
      1,
      "Android Development"
  )
    db.bookDao().saveBook(book)
    db.bookDao().getAllBook().forEach {
        Log.d("FetchDatabase>>>>", "${it.bookID}")
        Log.d("FetchDatabase>>>>", "${it.boookName}")
 //   }

} .start()
//   }
}      */
// db.bookDao().saveBook(book)
//  db.bookDao().getAllBook().forEach
