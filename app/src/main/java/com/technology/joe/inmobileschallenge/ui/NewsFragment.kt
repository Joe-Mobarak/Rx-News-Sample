package com.technology.joe.inmobileschallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.technology.joe.inmobileschallenge.R
import com.technology.joe.inmobileschallenge.ui.adapter.NewsAdapter
import com.technology.joe.inmobileschallenge.ui.viewmodel.NewsViewModel
import data.model.Article
import kotlinx.android.synthetic.main.activity_news.*

class NewsFragment : Fragment() {
    private lateinit var adapter: NewsAdapter
    private lateinit var viewModel: NewsViewModel
    private val storesList: ArrayList<Article> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpViewModel()
        setPullToRefresh()
    }


    private fun setUpRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(activity)
        adapter = NewsAdapter(storesList, object : NewsAdapter.INewsItemSelected {
            override fun onNewsItemsClicked(position: Int) {
                (activity as MainActivity).addFragment(MainActivity.FragmentTypes.NEWS_DETAILS,(storesList[position]))
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
