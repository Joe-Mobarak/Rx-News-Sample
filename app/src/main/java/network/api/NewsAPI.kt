package network.api

import base.Resource
import data.model.Article
import data.model.NewsAPIResult
import network.builder.RetrofitBuilder
import network.service.NewsAPIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsAPI {

    fun getAll(
        date: String,
        type: String,
        sortBy: String,
        apiKey: String,
        closure: (Resource<List<Article>>?) -> Unit
    ) {
        val retrofitBuilder = RetrofitBuilder()
        val service = retrofitBuilder.createRetrofitService()!!.create(NewsAPIInterface::class.java)
        val stringCall: Call<NewsAPIResult>
        stringCall = service.getAll(date, type, sortBy, apiKey)

        stringCall.enqueue(object : Callback<NewsAPIResult> {
            override fun onResponse(
                call: Call<NewsAPIResult>,
                response: Response<NewsAPIResult>
            ) {
                if (response.isSuccessful) {
                    closure(
                        Resource(
                            Resource.STATUS_SUCCESS,
                            response.body()?.articles
                        )
                    )
                } else closure(Resource(Resource.STATUS_ERROR, null))
            }

            override fun onFailure(call: Call<NewsAPIResult>, t: Throwable) {
                closure(Resource(Resource.STATUS_NO_INTERNET, null))
            }
        })
    }
}
