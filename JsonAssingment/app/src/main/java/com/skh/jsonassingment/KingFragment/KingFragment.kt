package com.skh.jsonassingment.KingFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.skh.jsonassingment.Api.ApiClient
import com.skh.jsonassingment.R
import com.skh.jsonassingment.model.KingItem
import retrofit2.Call


class KingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_king, container, false)
        getKing()

    }

    fun getKing() {
        val apiClient = ApiClient()
        val apiCall = apiClient.KingApiService.getKing()

        apiCall.enqueue(object : retrofit2.Callback<ArrayList<KingItem>> {
            override fun onFailure(call: Call<ArrayList<KingItem>>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
            override fun on
        })
    }
}