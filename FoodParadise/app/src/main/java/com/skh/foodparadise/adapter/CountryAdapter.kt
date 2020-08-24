package com.skh.foodparadise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skh.foodparadise.R
import com.skh.foodparadise.model.Category
import com.skh.foodparadise.model.Country
import com.skh.foodparadise.model.MealXX
import com.skh.foodparadise.model.Meals
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter (var countryList: List<MealXX> = ArrayList<MealXX>()) :
  RecyclerView.Adapter<CountryAdapter.HomeViewHolder>(){


    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        lateinit var country: Country
        fun bind(country: MealXX){
//            this.country = country
            itemView.country_name.text= country.strMeal
        }
    }
    fun updateCategory (countrylist: List<MealXX>) {
        this.countryList =countrylist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(countryList.get(position))
    }
}