package com.skh.roomdatabase.adapter

import android.icu.util.ULocale
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skh.roomdatabase.R
import com.skh.roomdatabase.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter
    (var categoryList: List<Book> = ArrayList<Book>()) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>(){
     private var books = emptyList <Book>()

    var mClickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }


    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        lateinit var book: Book

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(book: Book) {
            this.book = book
            itemView.itemBook.text = book.boookName
        }

        override fun onClick(view: View?) {
            mClickListener?.onClcik(book)
        }
    }
     fun addBookList (bookList: List<Book>){
         this.bookList=bookList
         notifyDataSetChanged()
     }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int  = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(categoryList.get(position))
    }
    interface ClickListener {
        fun onClcik(book: Book)
    }

}

