package com.technology.joe.inmobileschallenge.ui.application

import android.app.Application
import com.technology.joe.inmobileschallenge.ui.viewmodel.NewsViewModelFactory
import data.repository.NewsRepository
import network.api.NewsAPI
import network.builder.RetrofitBuilder
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

class MyApplication : Application(), KodeinAware {

    //Setup Dependency Injection
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApplication))
        bind() from provider { NewsViewModelFactory(instance()) }
        bind() from provider { NewsRepository(instance()) }
        bind() from provider { NewsAPI(instance()) }
        bind() from provider { RetrofitBuilder() }
    }

}
