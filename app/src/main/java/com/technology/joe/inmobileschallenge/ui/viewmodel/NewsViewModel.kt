package com.technology.joe.inmobileschallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import base.Resource
import com.technology.joe.inmobileschallenge.BuildConfig
import data.model.Article
import data.repository.NewsRepository
import util.Utils

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    private val _news: MutableLiveData<Resource<List<Article>>> = MutableLiveData()
    val news: LiveData<Resource<List<Article>>>
        get() = _news

    init {
        getAllNews()
    }

    fun getAllNews() {
        val type = "news"
        val sortBy = "publishedAt"
        newsRepository.getAll(Utils.getCurrentDate(), type, sortBy, BuildConfig.apiKey) {
            _news.postValue(it)
        }

    }

}
