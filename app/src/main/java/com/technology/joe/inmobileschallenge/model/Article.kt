package com.technology.joe.inmobileschallenge.model

import com.squareup.moshi.Json
import java.io.Serializable

data class Article(
    @field:Json(name = "author") val author: String,
    @field:Json(name = "content") val content: String,
    @field:Json(name = "publishedAt") val publishedAt: String,
    @field:Json(name = "source") val source: Source,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "url") val url: String,
    @field:Json(name = "urlToImage") val urlToImage: String
) : Serializable
