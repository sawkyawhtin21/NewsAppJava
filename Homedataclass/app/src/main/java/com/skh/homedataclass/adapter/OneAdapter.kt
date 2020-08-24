package com.skh.homedataclass.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skh.homedataclass.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_one.view.*
import kotlinx.android.synthetic.main.fragment_two.view.*
import kotlinx.android.synthetic.main.item_main.view.*

class OneAdapter (var Personlist: ArrayList<Person>) :
                 RecyclerView.Adapter<OneAdapter.PersonViewHolder>() {
    var clickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener){
        this.clickListener = clickListener
    }


    inner  class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
     lateinit var person: Person
        init {
            itemView.setOnClickListener(this)
        }

    fun bindPerson(person : Person) {
        this.person=person
      //       itemView.image1.setImageResource(person.img1)
        itemView.btntwo.text = person.txt1



    }

        override fun onClick(p0: View?) {
            clickListener?.onClick(person)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_main,
            parent,false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Personlist.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bindPerson(Personlist[position])
    }
    interface ClickListener{
        fun onClick (person: Person)
    }

}
