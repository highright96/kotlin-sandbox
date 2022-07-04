package com.highright.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun main() {
    println("Main Start by ${Thread.currentThread().name}")

    val dur1 = measureTimeMillis {
        showNewsLaunch()
    }

    println("Main End $dur1 by ${Thread.currentThread().name}")

    val dur2 = measureTimeMillis {
        showNewsWithContext()
    }

    println("Main End $dur2 by ${Thread.currentThread().name}")
}

suspend fun example() {
    return withContext(Dispatchers.IO) {
        (1..1000).sortedByDescending {
            println("Job 수행중 by ${Thread.currentThread().name}")
            it
        }
    }
}

suspend fun showNewsLaunch() {
    coroutineScope {
        launch { getLaunchA() }
        launch { getLaunchB() }
        launch { getLaunchC() }
    }
}

suspend fun showNewsWithContext() {
    getA()
    getB()
    getC()
}

suspend fun getLaunchA() {
    delay(1000L)
    println("A 수행중 by ${Thread.currentThread().name}")
}

suspend fun getLaunchB() {
    delay(1000L)
    println("B 수행중 by ${Thread.currentThread().name}")
}

suspend fun getLaunchC() {
    delay(1000L)
    println("C 수행중 by ${Thread.currentThread().name}")
}

suspend fun getA() {
    return withContext(Dispatchers.Default) {
        delay(1000L)
        println("A 수행중 by ${Thread.currentThread().name}")
    }
}

suspend fun getB() {
    return withContext(Dispatchers.Default) {
        delay(1000L)
        println("B 수행중 by ${Thread.currentThread().name}")
    }
}

suspend fun getC() {
    return withContext(Dispatchers.Default) {
        delay(1000L)
        println("C 수행중 by ${Thread.currentThread().name}")
    }
}