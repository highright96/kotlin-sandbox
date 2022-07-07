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

    /*
    중간 연산자는 내부에서 일시 중단 가능한 함수들을 호출 가능하다.
    */
    val time = measureTimeMillis {
        (1..3).asFlow()
            .map { request -> performRequest(request) }
            .collect { response -> println(response) }
    }
    println(time)

    /*
    Transform operator
    1. map 과 filter 와 같은 간단한 역할을 하는 변형 연산자도 있지만, transform 연산자를 사용해 좀 더 복잡한 변형들을 적용할 수 있다.
    2. 아래 처럼 긴 작업을 비동기로 수행하기 전에 문자열을 배출할 수 있다.
    */
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