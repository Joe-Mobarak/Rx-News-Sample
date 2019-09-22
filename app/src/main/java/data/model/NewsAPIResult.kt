package data.model

import com.google.gson.annotations.SerializedName

data class NewsAPIResult(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)
