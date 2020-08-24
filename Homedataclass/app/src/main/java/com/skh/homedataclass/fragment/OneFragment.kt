package com.skh.homedataclass.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.skh.homedataclass.R
import com.skh.homedataclass.adapter.OneAdapter
import com.skh.homedataclass.adapter.Person
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*


class OneFragment : Fragment(), OneAdapter.ClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)





    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var Personlist = ArrayList<Person>()
        Personlist.add(Person(R.drawable.ic_android_black_24dp,"find u name"))

        var oneAdapter = OneAdapter(Personlist)
      /*  recyclerview.apply{
           layoutManager=LinearLayoutManager(context)
           adapter=OneAdapter
       } */
    recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = oneAdapter
        oneAdapter.setOnClickListener(this)

    }

    override fun onClick(person: Person) {
       var action = OneFragmentDirections.actionOneFragment2ToTwoFragment(person.txt1,person.img1)
        view!!.findNavController().navigate(action)
    }


}