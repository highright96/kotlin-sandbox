package com.highright.coroutines

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineCancelTest {

    @Test
    fun 취소() = runBlocking {

        //이 코루틴들은 메인 스레드에서 동작한다
        val job = launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ... by ${Thread.currentThread().name}")
                delay(500L)
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting! by ${Thread.currentThread().name}")
        job.cancelAndJoin() // cancels and join
        println("main: Now I can quit. by ${Thread.currentThread().name}")
    }

    @Test
    fun 계산_취소_안됨() = runBlocking {
        val startTime = System.currentTimeMillis()

        //이 코루틴은 다른 스레드에서 실행된다
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            // CPU 계산 작업을 한다면 cancel 을 해도 바로 취소되지 않는다
            while (i < 10) {
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ... by ${Thread.currentThread().name}")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting! by ${Thread.currentThread().name}")
        job.cancelAndJoin() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }

    @Test
    fun non_Cancellable() = runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i ... by ${Thread.currentThread().name}")
                    delay(500L)
                }
            } finally {
                // cancel 에 영향을 받지 않음
                withContext(NonCancellable) {
                    println("job: I'm running finally by ${Thread.currentThread().name}")
                    delay(2000L)
                    println("job: And I've just delayed for 2 sec because I'm non-cancellable 요부분을 실행할 수 있다 by ${Thread.currentThread().name}") // 요부분을 실행할 수 있다
                }
            }
        }

        delay(1300L) // delay a bit
        println("main: I'm tired of waiting! by ${Thread.currentThread().name}")
        job.cancelAndJoin() // cancels the job and waits for its completion // CancelledException 발생시킴
        println("main: Now I can quit. by ${Thread.currentThread().name}")
    }
}