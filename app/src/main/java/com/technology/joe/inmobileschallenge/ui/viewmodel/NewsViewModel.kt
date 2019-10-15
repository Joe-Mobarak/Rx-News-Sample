package com.technology.joe.inmobileschallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import base.Resource
import com.technology.joe.inmobileschallenge.BuildConfig
import data.model.Article
import network.service.NewsAPIService
import util.IRxSchedulers
import util.Utils

class NewsViewModel(private val api: NewsAPIService, private val schedulers: IRxSchedulers) :
    BaseViewModel() {

    private val _news: MutableLiveData<Resource<List<Article>>> = MutableLiveData()
    val news: LiveData<Resource<List<Article>>>
        get() = _news

    init {
        getAllNews()
    }

    fun getAllNews() {
        val type = "news"
        val sortBy = "publishedAt"
        addToDisposable(api.getAll(Utils.getCurrentDate(), type, sortBy, BuildConfig.apiKey)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .doFinally { }
            .doOnError{
                _news.postValue(Resource(it,null))}
            .subscribe({ response ->
                _news.postValue(Resource(null, response.articles)) }, {})
        )

    }
}
