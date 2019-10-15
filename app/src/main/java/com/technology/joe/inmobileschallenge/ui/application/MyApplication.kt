package com.technology.joe.inmobileschallenge.ui.application

import android.app.Application
import com.technology.joe.inmobileschallenge.di.activityModule
import com.technology.joe.inmobileschallenge.di.appModule
import com.technology.joe.inmobileschallenge.di.networkModule
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
