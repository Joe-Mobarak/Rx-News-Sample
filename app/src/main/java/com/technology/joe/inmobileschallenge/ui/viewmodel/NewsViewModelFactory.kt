package com.technology.joe.inmobileschallenge.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import network.service.NewsAPIService
import util.IRxSchedulers

class NewsViewModelFactory(private val api: NewsAPIService, private  val schedulers: IRxSchedulers) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(api,schedulers) as T
    }
}
