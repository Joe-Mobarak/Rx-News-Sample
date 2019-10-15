package com.technology.joe.inmobileschallenge.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.technology.joe.inmobileschallenge.network.service.NewsAPIService
import com.technology.joe.inmobileschallenge.util.IRxSchedulers

class NewsViewModelFactory(private val api: NewsAPIService, private  val schedulers: IRxSchedulers) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(api,schedulers) as T
    }
}
