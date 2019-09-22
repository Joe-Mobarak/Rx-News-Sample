package com.technology.joe.inmobileschallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.technology.joe.inmobileschallenge.R
import com.technology.joe.inmobileschallenge.ui.adapter.NewsAdapter
import data.model.Article
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    private lateinit var adapter: NewsAdapter
    private val storesList: ArrayList<Article> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter(storesList)
        recycler_view.adapter = adapter
    }
}
