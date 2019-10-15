package com.joe.news.di


import com.joe.news.ui.viewmodel.NewsViewModelFactory
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

private const val MODULE_NAME = "Activity Module"

val activityModule = Module(MODULE_NAME, false) {
    bind() from provider { NewsViewModelFactory(instance(), instance()) }
}
