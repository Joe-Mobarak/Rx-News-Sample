package com.joe.news.ui.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.joe.news.R
import com.joe.news.databinding.NewsRowBinding
import com.squareup.picasso.Picasso
import com.joe.news.model.Article

class NewsAdapter(private val news: ArrayList<Article>, val iNewsItemSelected: INewsItemSelected) :
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
        if (!TextUtils.isEmpty(model.urlToImage))
        Picasso.get().load(model.urlToImage).placeholder(R.drawable.news_ic_placeholder)
            .into(holder.binding.newsImage)
        holder.binding.parentLayout.setOnClickListener {
            iNewsItemSelected.onNewsItemsClicked(position)
        }
    }


    class NewsItemViewHolder(val binding: NewsRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface INewsItemSelected {
        fun onNewsItemsClicked(position: Int)
    }
}
