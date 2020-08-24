package com.skh.skhtmdbmovies.fragment

import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.media.AudioAttributesCompat.fromBundle
import com.skh.skhtmdbmovies.R
import com.skh.skhtmdbmovies.api.TmdbApiClient
import com.skh.skhtmdbmovies.model.Result
import kotlinx.android.synthetic.main.fragment_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime.from
import java.time.chrono.HijrahDate.from
import java.util.Date.from
import java.util.GregorianCalendar.from


class DetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.item_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var urlBundle = arguments?.let {
            DetailsFragment.fromBundle(it)
        }
        var url: String = urlBundle?.articleUrl.toString()
        webView.loadUrl(url)
    }
}