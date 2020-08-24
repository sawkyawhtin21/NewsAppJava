package com.skh.homedataclass.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skh.homedataclass.R
import kotlinx.android.synthetic.main.fragment_two.*


class TwoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var nameArgs = arguments?.let {
            TwoFragmentArgs.fromBundle(it)

        }

        var name: String = nameArgs?.name.toString()
        Log.d("message",name)
        frg2.text = name
    }


}