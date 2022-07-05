package com.highright.coroutines.composing_suspending_functions

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.ArithmeticException
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        //val result = concurrentSum()
        try {
            failedConcurrentSum()
        } catch(e: ArithmeticException) {
            println("Computation failed with ArithmeticException")
        }
    }
    println("$time ms")
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
    one.await() + two.await()
}

/*
코루틴 스코프 내의 코루틴이 하나라도 실패하면 모두 취소된다.
*/
suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async {
        try {
            delay(Long.MAX_VALUE)
            42
        } finally {
            println("First child was cancelled")
        }
    }

    val two = async<Int> {
        println("Second child throws an exception")
        throw ArithmeticException()
    }

    one.await() + two.await()
}