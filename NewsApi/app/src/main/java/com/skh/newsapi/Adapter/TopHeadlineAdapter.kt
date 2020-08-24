package com.skh.newsapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skh.newsapi.R
import com.skh.newsapi.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_topheadlines.view.*
import java.lang.reflect.Array.get
import java.nio.file.Files.size
import kotlin.coroutines.coroutineContext

class TopHeadlineAdapter (var newsList : ArrayList<Article> = ArrayList<Article>()) : RecyclerView.Adapter<TopHeadlineAdapter.TopHeadlineViewHolder>() {
    class TopHeadlineViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
       var mClickLinstener : clickListener? = null

            fun bind(article: Article) {
                Picasso.get().load(article.urlToImage).into(itemView.img1);
                itemView.txt1.text = article.title
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlineViewHolder {
var view = LayoutInflater.from(parent.context).inflate(R.layout.item_topheadlines,parent,false)
        return TopHeadlineViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: TopHeadlineViewHolder, position: Int) {
       holder.bind(newsList[position])
    }
    interface clickListener{
        fun onClick (article: Article)
    }

}