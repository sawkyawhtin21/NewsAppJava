package com.myogardener.database

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.myogardener.database.adapter.BookAdapter
import com.myogardener.database.database.BookDatabase
import com.myogardener.database.model.Book
import com.myogardener.database.viewModel.BookViewModel
import kotlinx.android.synthetic.main.activity_addbook.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_update.view.*
import java.util.EnumSet.of
import java.util.List.of

class MainActivity : AppCompatActivity(), BookAdapter.ClickListener {

    lateinit var bookAdapter: BookAdapter
    lateinit var bookViewModel: BookViewModel
    private val addBookActivityResultCode = 1 // request code in fun onActivityresult

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        bookAdapter = BookAdapter()

        recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookAdapter
        }
        bookViewModel.allbook.observe(
            this, Observer { book ->
                book.let {
                    bookAdapter.addBookList(book)
                }
            }
        )
        btn_add.setOnClickListener {
            var intent = Intent(this, AddbookActivity::class.java)
            //     startActivity(intent)

            startActivityForResult(intent, addBookActivityResultCode)
        }
        bookAdapter.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == addBookActivityResultCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(AddbookActivity.EXTRA_REPLY)?.let {
                val book = Book(it)
                bookViewModel.insert(book)
            }
        }
    }

    override fun onClick(book: Book) {


        var builder=AlertDialog.Builder(this)
        builder.apply {
            setTitle("Delete item")
            setIcon(android.R.drawable.ic_dialog_alert)
            setPositiveButton("Yes"){
                    dialogInterface, i ->
                bookViewModel.deleteItem(book.bookName)
            }
            setNegativeButton("No"){
                dialogInterface, i ->
                Toast.makeText(applicationContext,"Delete cancel",Toast.LENGTH_LONG).show()
            }



            setNeutralButton("Update"){ dialogInterface: DialogInterface, i: Int ->
                val updateBuilder=AlertDialog.Builder(context)
                val dialogLayout=layoutInflater.inflate(
                    R.layout.dialog_update,null
                )
                updateBuilder.apply {
                    setTitle("Update Book")
                    setView(dialogLayout)
                    setPositiveButton("OK"){dialogInterface, i ->
                        var updateText=dialogLayout.edit_update.text.toString()
                        bookViewModel.updateItem(updateText,book.bookName)
                    }
                }
                val updateDialog:AlertDialog=updateBuilder.create()
                updateDialog.show()
            }
        }
val alertDialog:AlertDialog=builder.create()
        alertDialog.show()
    }

}


//
//        val db= Room.databaseBuilder(
//            applicationContext,
//            BookDatabase::class.java,
//            "BookDB"
//        ).build()
//        Thread{
//            val book= Book(1, "Android Developement")
//
//            db.bookDao().saveBook(book)
//            db.bookDao().getAllBook().forEach{
//                Log.d("FetchDatabase>>>>>>","${it.bookID}")
//                Log.d("FetchDatabase>>>>>","${it.bookName}")
//            }
//        }.start()
