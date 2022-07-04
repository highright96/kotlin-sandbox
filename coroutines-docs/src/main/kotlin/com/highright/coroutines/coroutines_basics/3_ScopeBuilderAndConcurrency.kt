package com.highright.coroutines.coroutines_basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    val time = measureTimeMillis {
        doWorld3()
        /*
        doWorld3 함수는 코루틴스코프 내의 모든 코루틴이 종료되어야 리턴된다. 따라서 아래의 코드는 실행되지 않는다.
        너무 당연한 이야기!! 코루틴 스코프 내에서 비동기적으로 코드를 짤 수 있는 것이지 그 외에는 동기적으로 작동한다.
        */
        println("Done!")
    }

    println("${time}ms")
}

/*
두개의 launch 블록은 동시에 실행된다.
따라서 총 3초가 아닌 2.xxx 초가 걸린다.
*/
suspend fun doWorld3() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2 by ${Thread.currentThread().name}")
    }

    launch {
        delay(1000L)
        println("World 1 by ${Thread.currentThread().name}")
    }

    println("Hello")
}