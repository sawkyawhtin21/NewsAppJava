package com.skh.newsapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.skh.newsapi.Adapter.ApiAdapter
import com.skh.newsapi.Adapter.TopHeadlineAdapter
import com.skh.newsapi.R
import com.skh.newsapi.R.id.action_topHeadlinesragment_to_secondragment
import com.skh.newsapi.R.id.topHeadlinesragment
import com.skh.newsapi.api.ApiClient
import com.skh.newsapi.model.Article
import com.skh.newsapi.model.News
import com.skh.newsapi.viewmodel.NewViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_top_headlinesragment.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class TopHeadlinesragment : Fragment(), TopHeadlineAdapter.clickListener {
    lateinit var viewModel: NewViewModel
    lateinit var topHeadlineAdapter: TopHeadlineAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_headlinesragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var viewmodel = ViewModelProvider(this).get(NewViewModel::class.java)
        topHeadlineAdapter= TopHeadlineAdapter()
        //topHeadlineAdapter.s(this)


        viewmodel.loadResult()
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewmodel.getResult().observe(
            viewLifecycleOwner, Observer<News> { news ->
                recyclerView.adapter = TopHeadlineAdapter(news.articles)

            }
        )
        viewmodel.getLoading().observe((viewLifecycleOwner), Observer { isLoading ->
            // true
            if (isLoading) {
                View.VISIBLE
                // false
            } else {
                View.INVISIBLE
            }

        })
        viewmodel.getErrorstatus().observe((viewLifecycleOwner), Observer { status ->

            if (status) {
               viewmodel.getErrorMessage().observe(
                   viewLifecycleOwner, Observer { message->
                       txterror.text = message
                   }
               )
             }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadResult()
    }
    override fun onClick(article: Article){
        findNavController().navigate(R.id.action_topHeadlinesragment_to_secondragment)

    }
}







        // var apiClient = ApiClient()
        //  var apiCall = apiClient.getTopHealines()

        //   apiCall.enqueue(object : retrofit2.Callback<News>{
        //       override fun onFailure(call: Call<News>, t: Throwable) {
        //          txtResponse.text = t.toString()
        //       }

        //      override fun onResponse(call: Call<News>, response: Response<News>) {
        //         recyclerView.apply {
        //   layoutManager= LinearLayoutManager(context)
        //   adapter= ApiAdapter(response.body()!!)
  //  }
  // }

//  })




