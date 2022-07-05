package com.highright.coroutines.composing_suspending_functions

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
CoroutineStart.LAZY 를 사용하면 해당 코루틴이 호출되는 시점을 직접 control 할 수 있다.
start() 를 호출하지 않으면 코루틴은 순차적으로 작동한다.
*/

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }

        // some computation
        one.start() // start the first one
        two.start() // start the second one
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}