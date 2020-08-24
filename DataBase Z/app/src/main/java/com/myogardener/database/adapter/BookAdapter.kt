package com.myogardener.database.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myogardener.database.R
import com.myogardener.database.model.Book
import kotlinx.android.synthetic.main.item_home.view.*

class BookAdapter() :
    RecyclerView.Adapter<BookAdapter.HomeViewHolder>(){

    var mClickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }
    var bookList = emptyList<Book>()

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {

        lateinit var book: Book
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(book: Book) {
            this.book = book
            itemView.text1.text = book.bookName
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClick(book)
        }
    }
    fun updateArticle(bookList: List<Book>) {
        this.bookList = bookList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(bookList.get(position))
    }

    fun addBookList(bookList: List<Book>){
        this.bookList=bookList
        notifyDataSetChanged()
    }
    interface  ClickListener{
        fun onClick(book: Book)
    }

}