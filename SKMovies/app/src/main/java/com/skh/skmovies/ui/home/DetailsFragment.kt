package com.skh.skmovies.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.skh.skmovies.R
import com.skh.skmovies.modeldetails.Genre
import com.skh.skmovies.modeldetails.ModelDetails
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {

    lateinit var detailViewModel: HomeViewModel
    lateinit var modelDetails: ModelDetails

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //     var urlBundle = arguments?
        detailViewModel = ViewModelProvider(this)
            .get(HomeViewModel::class.java)
        var messageArgs = arguments?.let {
            DetailsFragmentArgs.fromBundle(it)
        }
        var id:String = messageArgs!! .detail
        Log.d ("id", id)
        onViewModel(id)

    }
    private fun onViewModel(movieid:String){

        var id= detailViewModel.loadNews2(movieid)
        detailViewModel.getModelDetail().observe(
            viewLifecycleOwner, Observer { movie->
                Log.d("moviedetail", movie.toString())
                detail_overview.text = movie.backdrop_path

                Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500/"+movie.poster_path)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(detaisimg)

            }
        )

    }
}