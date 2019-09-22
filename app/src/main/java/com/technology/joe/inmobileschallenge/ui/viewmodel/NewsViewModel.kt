package com.technology.joe.inmobileschallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.model.Article

class NewsViewModel : ViewModel() {
    private val _news: MutableLiveData<List<Article>> = MutableLiveData()
    val news: LiveData<List<Article>>
        get() = _news

}
