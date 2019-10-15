package com.technology.joe.inmobileschallenge.util

import io.reactivex.Scheduler

interface IRxSchedulers {
    fun main(): Scheduler
    fun io(): Scheduler
}
