package com.highright.coroutines.asynchronous_flow

import com.highright.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
Buffering
1. 오래 걸리는 작업 등이 관련이 있을 때, 다른 코루틴 안에서 flow 를 다르게 실행하는 것은 flow 가 수집 될 때, 전체적인 시간 관점에서 도움을 줄 수 있다.
2. 아래 예제에서 buffer() 를 사용하지 않으면 emit-collect 가 순차적으로 동작해서 1200ms 이상이 걸리는 반면에 buffer() 를 사용하면
emit-collect 를 동시에 실행할 수 있어서 더 빠르게 동작한다.
*/

fun simpleTask(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        log("Emit $i")
        emit(i)
    }
}


fun main() = runBlocking {
    val time1 = measureTimeMillis {
        simpleTask()
            .buffer()
            .collect {
                delay(300)
                log("Collect $it")
            }
    }
    println("Collected int $time1 ms")

    val time2 = measureTimeMillis {
        simpleTask()
            .conflate()
            .collect {
                delay(300)
                log("Collect $it")
            }
    }
    println("Collected int $time2 ms")
}