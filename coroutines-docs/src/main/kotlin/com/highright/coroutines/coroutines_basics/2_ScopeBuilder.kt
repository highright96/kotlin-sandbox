package com.highright.coroutines.coroutines_basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doWorld2()
}

suspend fun doWorld2() = coroutineScope {  // this: CoroutineScope
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}

/*
runBlocking 과 coroutineScope 는 body or 코루틴들이 종료되는 것을 기다린다는 점은 동일하다.
그러나 runBLocking 은 호출한 스레드가 모든 코루틴이 종료될때까지 Block 되고, coroutineScope 는 스레드가 block 되지 않고 다른 용도로 사용된다.

coroutineScope 는 일시중단이 가능한 함수에서 사용할 수 있다. ex) suspend fun A() {...}
 */