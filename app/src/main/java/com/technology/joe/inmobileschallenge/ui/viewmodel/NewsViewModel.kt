package com.technology.joe.inmobileschallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.model.Article
import data.repository.NewsRepository
import java.text.SimpleDateFormat
import java.util.*

class NewsViewModel : ViewModel() {
    private val _news: MutableLiveData<List<Article>> = MutableLiveData()
    val news: LiveData<List<Article>>
        get() = _news

    init {
        getAllNews()
    }

    private fun getAllNews() {
        val newsRepository = NewsRepository()
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
