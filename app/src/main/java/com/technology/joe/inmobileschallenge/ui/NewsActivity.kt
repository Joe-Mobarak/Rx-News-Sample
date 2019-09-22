package com.technology.joe.inmobileschallenge.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.technology.joe.inmobileschallenge.R
import com.technology.joe.inmobileschallenge.ui.adapter.NewsAdapter
import com.technology.joe.inmobileschallenge.ui.viewmodel.NewsViewModel
import data.model.Article
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    private lateinit var adapter: NewsAdapter
    private lateinit var viewModel: NewsViewModel
    private val storesList: ArrayList<Article> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        setUpRecyclerView()
        setUpViewModel()
        setPullToRefresh()
    }

    private fun setUpRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter(storesList, object : NewsAdapter.INewsItemSelected {
            override fun onNewsItemsClicked(position: Int) {
            }

        })
        recycler_view.adapter = adapter
    }

    private fun setUpViewModel() {
        viewModel = NewsViewModel()
        viewModel.news.observe(this, Observer {
            it?.let {
                storesList.clear()
                storesList.addAll(it)
                refresh.isRefreshing = false
                adapter.notifyDataSetChanged()
            }
        })
    }

    private fun setPullToRefresh() {
        refresh.setOnRefreshListener {
            viewModel.getAllNews()
        }
    }
}
