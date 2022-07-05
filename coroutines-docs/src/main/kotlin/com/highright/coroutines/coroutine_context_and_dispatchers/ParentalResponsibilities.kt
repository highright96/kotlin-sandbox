package com.highright.coroutines.composing_suspending_functions

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
부모 코루틴은 자신의 모든 자식 코루틴이 종료될 때까지 기다린다.
join 은 사실 필요없음. 단지 기다리는 지점을 정해줄뿐
*/

fun main(): Unit = runBlocking {
    // launch a coroutine to process some kind of incoming request
    val request = launch {
        repeat(3) { i -> // launch a few children jobs
            launch {
                delay((i + 1) * 200L) // variable delay 200ms, 400ms, 600ms
                println("Coroutine $i is done")
            }
        }

        println("request: I'm done and I don't explicitly join my children that are still active")
    }

    request.join() // wait for completion of the request, including all its children
    println("Now processing of the request is complete")
}