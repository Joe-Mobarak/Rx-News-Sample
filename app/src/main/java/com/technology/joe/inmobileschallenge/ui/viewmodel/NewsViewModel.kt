package com.technology.joe.inmobileschallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import base.Resource
import data.model.Article
import data.repository.NewsRepository
import java.text.SimpleDateFormat
import java.util.*

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    private val _news: MutableLiveData<Resource<List<Article>>> = MutableLiveData()
    val news: LiveData<Resource<List<Article>>>
        get() = _news

    init {
        getAllNews()
    }

     fun getAllNews() {
        val sdf = SimpleDateFormat(("yyyy/MM/dd"), Locale.US)
        val currentDate = sdf.format(Calendar.getInstance().time)
        val type = "news"
        val sortBy = "publishedAt"
        val apiKey = "c7a80f45eac941299d1e96acdf742568"
        newsRepository.getAll(currentDate, type, sortBy, apiKey) {
            _news.postValue(it)
        }

    }

}
