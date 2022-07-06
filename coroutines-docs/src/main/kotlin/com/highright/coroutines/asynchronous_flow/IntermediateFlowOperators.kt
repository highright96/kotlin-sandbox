package com.highright.coroutines.asynchronous_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun performRequest(request: Int): String {

    delay(1000)
    return "response $request"
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        (1..3).asFlow()
            .map { request -> performRequest(request) }
            .collect { response -> println(response) }
    }
    println(time)

    // Transform operator
    (1..3).asFlow()
        .transform { request ->
            emit("Making request $request")
            emit(request)
        }
        .collect { response -> println(response) }

    /*
    Size-limiting operators
    크기 제한 중간 연산자인 take() 를 사용해서 흐름 실행을 취소할 수 있다.
    */
    numbers()
        .take(2)
        .collect { value -> println(value) }
}

fun numbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } finally {
        println("Finally in numbers")
    }
}