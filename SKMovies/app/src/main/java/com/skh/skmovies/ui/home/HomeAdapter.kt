package com.skh.skmovies.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skh.skmovies.R
import com.skh.skmovies.model.nowplaying.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_home.view.*

//(var moviesList: List<Result> = ArrayList<Result>()) :
//RecyclerView.Adapter<HomeAdapter.HomeViewHolder>()
class HomeAdapter(var moviesList: List<Result> = ArrayList()):
RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

   var mClickListener: ClickListener? = null

   fun setOnClickListener(clickListener: ClickListener) {
      this.mClickListener = clickListener
   }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        lateinit var result:Result

        init {
            itemView.setOnClickListener(this)
        }



        fun bind(result: Result) {
           this.result = result
            itemView.text_home.text = result.original_title

            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+result.poster_path)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.nowPlaying)

     //       Picasso.get()
      //          .load("https://www.youtube.com/watch?v=MUALNBhZB7A&list=PLRRNzqzbPLd906bPH-xFz9Oy2IcjqVWCH&index=3"+result.poster_path)
      //          .placeholder(R.drawable.ic_launcher_background)
         //       .into(itemView.nowPlaying)
        }

        override fun onClick(view: View?) {
            mClickListener?.onClcik(result)
        }

    }

    fun updateMovies(moviesList: List<Result>) {
        this.moviesList = moviesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(moviesList.get(position))
    }

    interface ClickListener {
       fun onClcik(result: Result)
   }


}