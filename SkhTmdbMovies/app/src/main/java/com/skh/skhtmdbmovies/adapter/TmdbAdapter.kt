package com.skh.skhtmdbmovies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skh.skhtmdbmovies.R
import com.skh.skhtmdbmovies.model.Result
import com.skh.skhtmdbmovies.viewmodel.toSimpleString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movies.view.*

class TmdbAdapter(var videolist: List<com.skh.skhtmdbmovies.model.Result> = ArrayList<Result>()) :
    RecyclerView.Adapter<TmdbAdapter.TmdbViewHolder>() {
    var mClickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class TmdbViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {
        lateinit var result: Result
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(result: Result) {
            this.result = result
            itemView.TmdbTitle.text = result.title
            itemView.TmdbDescrip.text = result.overview
            itemView.TmdbDate.text = toSimpleString(result.release_date)
            Picasso.get()
                .load(result.poster_path)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.TmdbImage)

        }

        override fun onClick(p0: View?) {
            mClickListener?.onClcik(result)
        }
    }
    fun updateResult(videolist: List<Result>){
        this.videolist = videolist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TmdbViewHolder {
     val view = LayoutInflater.from(parent.context)
         .inflate(R.layout.item_movies,parent,false)
        return TmdbViewHolder(view)
    }

    override fun getItemCount(): Int {
     return videolist.size
    }

    override fun onBindViewHolder(holder: TmdbViewHolder, position: Int) {
    holder.bind(videolist.get(position))
    }
    interface ClickListener {
        fun onClcik(result: Result)
    }


}