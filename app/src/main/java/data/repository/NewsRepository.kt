package data.repository

import base.Resource
import data.model.Article
import network.api.NewsAPI

class NewsRepository(val newsAPI: NewsAPI) {

    fun getAll(
        date: String,
        type: String,
        sortBy: String,
        apiKey: String,
        closure: (Resource<List<Article>>) -> Unit
    ) {
        newsAPI.getAll(date, type, sortBy, apiKey)
        {
            it?.let {
                closure(it)
            }
        }
    }

}
