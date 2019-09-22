package com.technology.joe.inmobileschallenge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.technology.joe.inmobileschallenge.R
import com.technology.joe.inmobileschallenge.databinding.NewsRowBinding
import data.model.Article

class NewsAdapter(private val news: ArrayList<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>() {
    override fun getItemCount(): Int {
        return news.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        return NewsItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_news,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val model = news[position]
        holder.binding.authorText.text = model.author
        holder.binding.titleText.text = model.title
        Picasso.get().load(model.urlToImage).into(holder.binding.newsImage)
    }


    class NewsItemViewHolder(val binding: NewsRowBinding) :
        RecyclerView.ViewHolder(binding.root)

}
