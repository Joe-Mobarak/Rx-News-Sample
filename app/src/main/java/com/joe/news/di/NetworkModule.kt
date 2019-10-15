package com.joe.news.di

import com.joe.news.BuildConfig
import com.joe.news.network.service.NewsAPIService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val MODULE_NAME = "Network Module"

val networkModule = Module(MODULE_NAME, false) {
    bind<OkHttpClient>() with singleton { getMockOkHttpClient() }
    bind<Retrofit>() with singleton {
        getMockRetrofit(
            instance()
        )
    }
    bind<NewsAPIService>() with singleton {
        getMockApiService(
            instance()
        )
    }
}

private fun getMockOkHttpClient(): OkHttpClient {
    val httpBuilder = OkHttpClient.Builder()
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    httpBuilder.interceptors()
        .add(httpLoggingInterceptor)

    return httpBuilder.build()
}

private fun getMockRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.baseUrl)
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(okHttpClient)
    .build()

private fun getMockApiService(retrofit: Retrofit): NewsAPIService =
    retrofit.create(NewsAPIService::class.java)
