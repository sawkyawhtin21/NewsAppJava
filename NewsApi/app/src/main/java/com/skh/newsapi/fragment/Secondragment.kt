package com.skh.newsapi.fragment

import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
import androidx.media.AudioAttributesCompat.fromBundle
import com.skh.newsapi.R
import kotlinx.android.synthetic.main.fragment_secondragment.*
import kotlinx.android.synthetic.main.item_topheadlines.*


class Secondragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secondragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var messageArgs=arguments?. let {
            SecondragmentArgs.fromBundle(it)
        }
        var message:String? = messageArgs?.thorn.toString()
         text7.text=message
    }

}