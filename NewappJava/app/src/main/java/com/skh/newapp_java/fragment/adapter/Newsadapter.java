package com.skh.newapp_java.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skh.newapp_java.R;
import com.skh.newapp_java.model.ArticlesItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Newsadapter extends RecyclerView.Adapter<Newsadapter.ArticleViewHolder> {
    List<ArticlesItem> articlesItemList = new ArrayList<>();

    class    ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;

        public ArticleViewHolder(@NonNull View itemview) {
            super(itemview);

            title = itemview.findViewById(R.id.articleTitle);
            imageView = itemview.findViewById(R.id.articleImage);

        }
    }
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ArticleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.title.setText(articlesItemList.get(position).getTitle());
                Picasso.get()
                        .load(articlesItemList.get(position).getUrlToImage())
                        .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return articlesItemList.size();
    }

    public void UpdateArticle(List<ArticlesItem> articlesItems) {
        this.articlesItemList = articlesItems;
        notifyDataSetChanged();
    }


}

