package com.skh.foodparadise.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.skh.foodparadise.R
import com.skh.foodparadise.adapter.HomeAdapter
import com.skh.foodparadise.model.Category
import com.skh.foodparadise.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), HomeAdapter.ClickListener {

    lateinit var categoryViewModel: CategoryViewModel
    lateinit var homeAdapter: HomeAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        homeAdapter = HomeAdapter()
        recyclerview_home.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = homeAdapter
        }
        homeAdapter.setOnClickListener(this)
        observeViewmodel()
    }

    private fun observeViewmodel() {
        categoryViewModel.getResult().observe(
            viewLifecycleOwner, Observer { category ->
                homeAdapter.updateCategory(category.categories)
            }
        )
    }
    // use spinner to make a to z search bar

    override fun onResume() {
        super.onResume()
        categoryViewModel.loadCategories()
    }

    override fun onClcik(categories: Category) {
        var action = HomeFragmentDirections
            .actionHomeFragmentToCategoriesFragment(categories.strCategory)
        findNavController().navigate(action)
    }


}