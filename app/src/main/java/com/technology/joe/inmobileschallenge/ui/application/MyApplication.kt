package com.technology.joe.inmobileschallenge.ui.application

import android.app.Application
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
