package network.service

import data.model.NewsAPIResult
import io.reactivex.Single
import network.builder.UrlBuilder
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsAPIService {

    @GET(UrlBuilder.GET_ALL)
    fun getAll(
        @Query("from") date: String, @Query("q") type: String, @Query("sortBy") sortBy: String, @Query(
            "apiKey"
        ) apiKey: String
    ): Single<NewsAPIResult>

}
