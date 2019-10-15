package com.technology.joe.inmobileschallenge.di


import com.technology.joe.inmobileschallenge.ui.viewmodel.NewsViewModelFactory
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

private const val MODULE_NAME = "Activity Module"

val activityModule = Module(MODULE_NAME, false) {
    bind() from provider { NewsViewModelFactory(instance(), instance()) }
}
