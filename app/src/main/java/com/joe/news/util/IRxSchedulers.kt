package com.joe.news.util

import io.reactivex.Scheduler

interface IRxSchedulers {
    fun main(): Scheduler
    fun io(): Scheduler
}
