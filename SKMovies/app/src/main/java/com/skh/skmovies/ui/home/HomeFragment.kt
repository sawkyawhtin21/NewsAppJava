package com.skh.skmovies.ui.home

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import android.widget.VideoView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.common.api.Api
import com.skh.skmovies.R
import com.skh.skmovies.model.nowplaying.Result
import com.skh.skmovies.modeldetails.Genre
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),HomeAdapter.ClickListener {
    //    private lateinit var videoview : VideoView
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeAdapter: HomeAdapter

    //    private lateinit var webView: WebView
//    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView: View = inflater.inflate(R.layout.fragment_home, container, false)
        val myWebView = myView.findViewById<WebView>(R.id.webView_View) // webview
       myWebView.loadUrl("https://drive.google.com/file/d/15GInt90-wqcUVKyB5mYKSiB1QOI3uDAo/view?usp=sharing")
        val webSetting = myWebView.settings
        webSetting.javaScriptEnabled = true
        return myView        // webview
        // startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("")))



    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProvider(this)
            .get(HomeViewModel::class.java)

        homeAdapter = HomeAdapter()
        nav_home.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = homeAdapter
        }
        homeAdapter.setOnClickListener(this)
        observeViewmodel()


    }


    private fun observeViewmodel() {
        homeViewModel.loadMovies()
        homeViewModel.getResult().observe(
            viewLifecycleOwner, Observer { news ->
                homeAdapter.updateMovies(news.results)
            }
        )
    }


    override fun onClcik(result: Result) {
        var action = HomeFragmentDirections
            .actionNavHomeToDetailsFragment(result.id.toString())
        findNavController().navigate(action)
    }





}