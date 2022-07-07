package com.highright.coroutines.asynchronous_flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking

/*
flow { .. } 보다 흐름을 더 쉽게 정의할 수 있는 빌더가 있다.
*/

fun main() = runBlocking {
    (1..3).asFlow().collect { println(it) }
}