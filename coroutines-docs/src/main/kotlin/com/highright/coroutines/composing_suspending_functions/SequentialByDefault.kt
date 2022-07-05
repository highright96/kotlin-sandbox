package com.highright.coroutines.composing_suspending_functions

import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis

suspend fun main() {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("Answer ${one + two}")
    }

    println("$time ms")
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L)
    return 29
}

/*
코루틴은 기본적으로 코드가 순차적(Sequential)으로 실행된다.
함수 A 의 결과가 함수 B 의 결과에 종속적인 경우 위처럼 사용하면 순차적으로 동작한다.
따라서 총 2000ms 가 걸린다.
 */