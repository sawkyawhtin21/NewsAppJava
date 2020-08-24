package com.skh.skhtmdbmovies.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.skh.skhtmdbmovies.R
import com.skh.skhtmdbmovies.adapter.TmdbAdapter
import com.skh.skhtmdbmovies.viewmodel.Tmdbviewodel
import kotlinx.android.synthetic.main.fragment_tmdb.*


class TmdbFragment : Fragment() {

    lateinit var tmdbviewodel: Tmdbviewodel
    lateinit var tmdbAdapter: TmdbAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tmdb2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tmdbviewodel = ViewModelProvider(this)
            .get(Tmdbviewodel::class.java)

        tmdbAdapter = TmdbAdapter()
        recyclerHome.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = tmdbAdapter
        }
        tmdbAdapter.setOnClickListener(this)
        observeViewmodel()
    }

    private fun observeViewmodel() {
        tmdbviewodel.getResult().observe
    }
}
