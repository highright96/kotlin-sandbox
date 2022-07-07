package com.highright.coroutines.asynchronous_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/*
평탄화

*/
fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(500) // wait 500 ms
    emit("$i: Second")
}

fun main() = runBlocking {

    /*
    flatMapConcat
    1. flow 끼리의 연결(Concatenating) 은 flatMapConcat, flattenConcat 연산자를 통해서 이뤄지게 된다.
    2. 그리고 앞에서 말한 2개의 연산자는 순차 연산자에 와 같게 처리된다. (순서대로 처리 된다는 의미)
    */
    val startTime1 = System.currentTimeMillis() // remember the start time
    (1..3).asFlow().onEach { delay(100) } // a number every 100 ms
        .flatMapConcat { requestFlow(it) }
        .collect { value -> // collect and print
            println("$value at ${System.currentTimeMillis() - startTime1} ms from start")
        }

    println("------------------")

    /*
    FlatMapMerge
    1. 평탄화의 또 다른 방법은 모든 들어오는 flow 를 동시에 수집(collect) 하고, 하나의 flow 로 합쳐서 가능한 빨리 값을 배출시키는 방법k다.
    */
    val startTime2 = System.currentTimeMillis() // remember the start time
    (1..3).asFlow().onEach { delay(100) } // a number every 100 ms
        .flatMapMerge { requestFlow(it) }
        .collect { value -> // collect and print
            println("$value at ${System.currentTimeMillis() - startTime2} ms from start")
        }
}