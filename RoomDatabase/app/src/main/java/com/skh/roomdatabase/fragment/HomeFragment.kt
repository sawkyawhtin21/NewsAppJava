package com.skh.roomdatabase.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.skh.roomdatabase.R
import com.skh.roomdatabase.adapter.BookAdapter
import com.skh.roomdatabase.model.Book
import com.skh.roomdatabase.viewmodel.BookViewmodel

class HomeFragment : Fragment() /*{


 /*   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bookViewmodel= ViewModelProvider(this).get(BookViewmodel::class.java)
        val bookAdapter = BookAdapter()
        recyclerView.apply{
            layoutManager
        }
        bookViewmodel.insert(Book("Android"))
        bookViewmodel.allBook.observe(
            viewLifecycleOwner, Observer { book ->
             book.let {  }

            }
        )

        )
    }
} */