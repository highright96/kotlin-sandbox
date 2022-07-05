package com.highright.coroutines.composing_suspending_functions

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
함수 A 와 함수 B 가 서로 종속적이지 않고, 동시에 실행하게 하려면 async 를 사용하면 된다.
async 를 사용하면 다른 코루틴과 동시에 작동하는 경량 스레드인 코루틴을 시작한다.
await 가 호출되는 곳에서 결과를 기다린다.
 */
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() } // 새로운 코루틴 생성
        val two = async { doSomethingUsefulTwo() } // 새로운 코루틴 생성
        println("Answer ${one.await() + two.await()}") // 결과를 기다림, non-blocking
        println("End")
    }

    println("$time ms")
}