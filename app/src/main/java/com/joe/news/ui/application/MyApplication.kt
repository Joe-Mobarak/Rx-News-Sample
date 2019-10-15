package com.joe.news.ui.application

import android.app.Application
import com.joe.news.di.activityModule
import com.joe.news.di.appModule
import com.joe.news.di.networkModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class MyApplication : Application(), KodeinAware {

    //Setup Dependency Injection
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApplication))
        import(networkModule)
        import(activityModule)
        import(appModule)
    }

}
