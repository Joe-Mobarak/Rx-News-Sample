package com.technology.joe.inmobileschallenge.model

import com.squareup.moshi.Json

data class NewsAPIResult(
    @field:Json(name = "articles") val articles: List<Article>,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "totalResults") val totalResults: Int
)
