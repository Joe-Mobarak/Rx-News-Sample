package com.joe.news.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joe.news.network.service.NewsAPIService
import com.joe.news.util.IRxSchedulers

class NewsViewModelFactory(private val api: NewsAPIService, private  val schedulers: IRxSchedulers) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(api,schedulers) as T
    }
}
