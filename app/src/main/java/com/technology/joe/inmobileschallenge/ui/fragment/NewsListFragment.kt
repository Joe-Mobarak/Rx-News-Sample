package com.technology.joe.inmobileschallenge.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import base.Resource
import com.technology.joe.inmobileschallenge.R
import com.technology.joe.inmobileschallenge.ui.activity.NewsActivity
import com.technology.joe.inmobileschallenge.ui.adapter.NewsAdapter
import com.technology.joe.inmobileschallenge.ui.viewmodel.NewsViewModel
import com.technology.joe.inmobileschallenge.ui.viewmodel.NewsViewModelFactory
import data.model.Article
import kotlinx.android.synthetic.main.fragment_news_list.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import java.net.UnknownHostException

class NewsListFragment : Fragment(), KodeinAware {
    private lateinit var adapter: NewsAdapter
    private lateinit var viewModel: NewsViewModel
    private val storesList: ArrayList<Article> = ArrayList()
    override val kodein by closestKodein()
    private val viewModelFactory: NewsViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_list, container, false)
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
                (activity as NewsActivity).addFragment(
                    NewsActivity.FragmentTypes.NEWS_DETAILS,
                    (storesList[position])
                )
            }

        })
        recycler_view.adapter = adapter
    }

    private fun setUpViewModel() {
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(NewsViewModel::class.java)
        viewModel.news.observe(this, Observer {
            it?.let {
                if (it.throwable is UnknownHostException) {
                    no_internet_layout.visibility = View.VISIBLE
                    recycler_view.visibility = View.GONE
                    empty_layout.visibility = View.GONE
                } else {
                    it.data?.let {
                        if (it.isEmpty()) {
                            no_internet_layout.visibility = View.GONE
                            empty_layout.visibility = View.VISIBLE
                            recycler_view.visibility = View.GONE

                        } else {
                            no_internet_layout.visibility = View.GONE
                            recycler_view.visibility = View.VISIBLE
                            empty_layout.visibility = View.GONE
                            storesList.clear()
                            storesList.addAll(it)
                            adapter.notifyDataSetChanged()

                        }
                    }
                }
                refresh.isRefreshing = false
            }
        })
    }

    private fun setPullToRefresh() {
        refresh.setOnRefreshListener {
            viewModel.getAllNews()
        }
    }
}
