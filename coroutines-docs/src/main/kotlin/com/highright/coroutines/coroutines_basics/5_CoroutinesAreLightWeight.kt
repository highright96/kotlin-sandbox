package com.highright.coroutines.coroutines_basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    repeat(100_000) {
        launch {
            delay(5000L)
            print(".")
        }
    }
}

/*
코루틴을 사용하지 않고 직접 스레드를 생성하면 out-of-memory (OOM) 이 발생한다.
코루틴의 얼마나 가벼운지를 알려준다.
*/