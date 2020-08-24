package com.skh.jsonassingment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skh.jsonassingment.R
import com.skh.jsonassingment.model.KingItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_king.view.*
import kotlinx.android.synthetic.main.kingitem_post.view.*

class KingAdapter(var kinglist: ArrayList<KingItem>):
    RecyclerView.Adapter<KingAdapter.KingViewHolder>() {

    class KingViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bindpost(post: KingItem) {
            itemView.kingPost.text = post.`class`
            Picasso.get().load(post.img_url).into(itemView.King_image);
    }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingAdapter.KingViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.kingitem_post,parent,false)
        return KingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kinglist.size
    }

    override fun onBindViewHolder(holder: KingAdapter.KingViewHolder, position: Int) {
        holder.bindpost((kinglist[position]))
    }
}