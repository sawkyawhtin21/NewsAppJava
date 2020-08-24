package com.skh.json

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skh.json.model.PostItem
import kotlinx.android.synthetic.main.item_post.view.*
import java.time.DayOfWeek.from
import java.util.Date.from
import java.util.GregorianCalendar.from

class PostAdapter (var postlist: ArrayList<PostItem>):
RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    class PostViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bindpost(   post: PostItem) {
            itemView.txtPost.text = post.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
       return postlist.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindpost((postlist[position]))
    }
}