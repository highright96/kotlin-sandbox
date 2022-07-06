package com.highright.coroutines.asynchronous_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/*
Flow 는 상위 suspend 함수가 취소되면 flow 또한 취소된다.
*/

fun simpleCancel(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking {
    val result = withTimeoutOrNull(250) { // Timeout after 250ms
        simpleCancel().collect { value -> println(value) }
    }
    println("Done - $result")
}