package com.highright.coroutines.coroutines_basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { doWorld1() }
    println("Hello")
}

suspend fun doWorld1() {
    delay(1000L)
    println("World!")
}

/*
launch 는 코루틴 빌더이다. 독립적으로 실행되는 나머지 코드와 함께 실행되는 새로운 코루틴을 실행시킨다.

delay 는 특별한 일시중단 함수다. 코루틴을 특정 시간동안 일시 중단한다. 일시 중단되긴 하지만 스레드가 block 되는 것은 아니고, 새로운 코루틴이 스레드를 통해 실행될 수 있다.

runBlock {...} 은 내부의 모든 코루틴이 완료될때까지 이를 실행하는 스레드는 Block 된다.
*/