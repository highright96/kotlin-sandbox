package com.highright.coroutines.coroutines_basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
    job.join()
    println("Done!")
}
/*
launch 코루틴 빌더가 반환하는 Job 객체를 통해 코루틴을 handling 할 수 있다.
join() 을 통해 코루틴 결과를 기다리는 시점을 정해줄 수 있다.
*/