package com.highright.coroutines.coroutine_context_and_dispatchers

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
코루틴이 다르 코루틴의 CoroutineScope 에서 시작되면 CoroutineScope.coroutineContext 를 통해 컨텍스트를 상속하고
새 코루틴 작업은 상위 코루틴 작업의 자식이 된다. 따라서 코루틴 취소가 전파된다.

그러나 아래 예제와 같이 다른 Job 객체가 새 코루틴에게 전달되면 부모 코루틴이 변경되어 취소가 전파되지 않는다.
*/

fun main(): Unit = runBlocking {

    // launch a coroutine to process some kind of incoming request
    val request = launch {

        // it spawns two other jobs
        launch(Job()) {
            println("job1: I run in my own Job and execute independently!")
            delay(1000)
            println("job1: I am not affected by cancellation of the request")
        }

        // and the other inherits the parent context
        launch {
            delay(100)
            println("job2: I am a child of the request coroutine")
            delay(1000)
            println("job2: I will not execute this line if my parent request is cancelled")
        }
    }

    delay(500)
    request.cancel() // cancel processing of the request

    println("main: Who has survived request cancellation?")
    delay(1000) // delay the main thread for a second to see what happens
}