package com.highright.coroutines.asynchronous_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*
Flow 는 cold streams 이다.
flow 블록 내부에 있는 코드는 flow 가 collect 되기 전까지 실행되지 않는다.
*/

fun simple(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        println("emit $i")
        emit(i)
    }
}

fun main() = runBlocking {
    println("Calling simple function...")
    val flow = simple()
    println("Calling collect...")
    flow.collect { value -> println(value) }
    println("Calling collect again...")
    flow.collect { value -> println(value) }
}