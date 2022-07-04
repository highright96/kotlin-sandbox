package com.highright.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.concurrent.thread

class CoroutineScopeTest {

    @Test
    fun 포포몬스() = runBlocking {
        repeat(100_000) {
            delay(100L)
            println(".")
        }
    }

    @Test
    fun 포포몬쓰_스레드_OOM() {
        repeat(100_000) {
            thread {
                Thread.sleep(1000L)
                print(".")
            }
        }
    }

    @Test
    fun 헬로_코루틴() = runBlocking {
        launch {
            // new Coroutine
            delay(1000)
            println("Coroutine! by ${Thread.currentThread().name}") // 메인 스레드 안의 코루틴
        }
        println("Hello by ${Thread.currentThread().name}") //메인 스레드 안의 코루틴
    }

    @Test
    fun 헬로_어씽크() = runBlocking {
        val deffered = async {
            // new Coroutine
            delay(1000)
            println("async loop by ${Thread.currentThread().name}")
            "I'm Async"
        }

        println("Hello ${deffered.await()} by ${Thread.currentThread().name}")
    }
}