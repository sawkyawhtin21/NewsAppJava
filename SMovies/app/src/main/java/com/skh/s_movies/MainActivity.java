package com.skh.s_movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.skh.s_movies.adapter.BannerMoviesPagerAdapter;
import com.skh.s_movies.model.BannerMovies;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout tabLayout;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> bannerMoviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //    tabLayout = findViewById()
        bannerMoviesList = new ArrayList<>();
        bannerMoviesList.add(new BannerMovies(1, "PONMAGAL VANDHAL", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner1.png", ""));
        bannerMoviesList.add(new BannerMovies(2, "LITTLE WOMEN", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner2.png", ""));
        bannerMoviesList.add(new BannerMovies(3, "BHOOT", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner3.png", ""));
        bannerMoviesList.add(new BannerMovies(4, "MIRZAPUR", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner4.png", ""));
        bannerMoviesList.add(new BannerMovies(5, "PIKACHU", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner5.png", ""));
        setBannerMoviesPagerAdapter(bannerMoviesList);
    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
    }
}