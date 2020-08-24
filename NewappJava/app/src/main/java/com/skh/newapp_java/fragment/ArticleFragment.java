package com.skh.newapp_java.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.skh.newapp_java.R;
import com.skh.newapp_java.fragment.adapter.Newsadapter;
import com.skh.newapp_java.viewmodel.NewsViewModel;


public class ArticleFragment extends Fragment {
RecyclerView recyclerView;
NewsViewModel newsViewModel;
Newsadapter newsadapter=new Newsadapter();
ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_article, container, false);

        recyclerView = root.findViewById(R.id.newsrecyclerview);
        progressBar = root.findViewById(R.id.loadingView);

        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        newsViewModel .loadResults();

        recyclerView.setLayoutManager (new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(newsadapter);

        newsViewModel.getResults().observe(
                getViewLifecycleOwner(), news -> {
                    newsadapter.UpdateArticle(news.getArticles());
                }
        );
        newsViewModel.getLoading().observe(
                getViewLifecycleOwner(), loading -> {
                    if (loading) {
                        progressBar.setVisibility(View.VISIBLE);
                    }else {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
        );

        // Inflate the layout for this fragment
        return root;
    }
}