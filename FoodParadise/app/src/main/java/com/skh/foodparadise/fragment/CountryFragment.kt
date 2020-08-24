package com.skh.foodparadise.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.skh.foodparadise.R
import com.skh.foodparadise.adapter.CountryAdapter
import com.skh.foodparadise.adapter.HomeAdapter
import com.skh.foodparadise.model.Category
import com.skh.foodparadise.model.Country
import com.skh.foodparadise.viewmodel.CategoryViewModel
import com.skh.foodparadise.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_country.*

class CountryFragment : Fragment() {
    lateinit var countryViewModel: CountryViewModel
    lateinit var countryadapter: CountryAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryViewModel = ViewModelProvider(this).get(CountryViewModel::class.java)

        countryadapter = CountryAdapter()

        countryrecycler.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = countryadapter
        }
//        homeAdapter.setOnClickListener(this)
     //   observeViewmodel()
    }
    private fun observeViewmodel() {
        countryViewModel.getResult().observe(
            viewLifecycleOwner, Observer { country ->
                countryadapter.updateCategory(country)
            }
        )
    }    override fun onResume() {
        super.onResume()
        countryViewModel.loadCategories()
    }

    override fun onClcik(countries: Country) {
        var action = HomeFragmentDirections
            .actionHomeFragmentToMealsFragment(countries.)
        findNavController().navigate(action)
    }

}

