package com.highright.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class CoroutineConcurrencyTest {

    private suspend fun massiveRun(action: suspend () -> Unit) {
        val n = 100  // 생성되는 코루틴의 수
        val k = 1000 // 각 코루틴마다 실행할 액션의 수
        val time = measureTimeMillis {
            coroutineScope { // scope for coroutines
                repeat(n) {
                    launch {
                        repeat(k) {
                            println("action by ${Thread.currentThread().name}")
                            action()
                        }
                    }
                }
            }
        }
        println("Completed ${n * k} actions in $time ms by ${Thread.currentThread().name}")
    }

    // 공유 카운터
    var counter = 0

    // Dispatchers.Default 를 통해 멀티스레드에서 실행되므로 결과가 맞지 않음
    @Test
    fun massiveRunError() = runBlocking {
        withContext(Dispatchers.Default) {
            massiveRun {
                counter++
            }
        }
        println("massiveRunError Counter = $counter by ${Thread.currentThread().name}")
    }

    // 싱글 스레드
    private val singleThread = newSingleThreadContext("CounterContext")

    @Test
    fun massiveRunSingleThread1() = runBlocking {
        withContext(Dispatchers.Default) {
            massiveRun {
                // 매 증가연산마다 Dispatchers.Default 에서 singleThread 로 컨텍스트 스위칭이 일어나므로 느림
                withContext(singleThread) {
                    counter++
                }
            }
            println("massiveRunSingleThread1 Counter = $counter")
        }
    }

    @Test
    fun massiveRunSingleThread2() = runBlocking {
        // 큰 단위의 비지니스 로직을 싱글 스레드로 한정
        withContext(singleThread) {
            massiveRun {
                counter++
            }
        }
        println("massiveRunSingleThread2 Counter = $counter")
    }

    // mutex 를 통한 임계구역 제어
    private val mutex = Mutex()

    // 상호배제
    @Test
    fun massiveRunMutex() = runBlocking {
        withContext(Dispatchers.Default) {
            massiveRun {
                // 코드가 임계 구역에 있는 경우 하나의 루틴만 접근하는 것을 보장
                mutex.withLock {
                    counter++
                }
            }
        }
        println("massiveRunMutex Counter = $counter")
    }
}