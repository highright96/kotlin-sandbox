package com.highright.coroutines.coroutine_context_and_dispatchers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
Dispatchers.Unconfined 디스패처는 호출자 스레드에서 코루틴을 시작한다. 다만 첫 번째 중단 지점까지만 해당 스레드로 실해된다.
일시 중단 후 일시 중단 함수에 의해 결정된 스레드에서 코루틴을 재개한다.

Dispatchers.Default (선택 X) 디스패처는 기본적으로 외부 코루틴 스코프에 상속된다. 아래 예제의 runBlocking 코루틴의 기본 디스패처는
호출자 스레드로 결정되고 내부 디폴트 디스패처를 사용하는 코루틴은 이를 상속받는다.
*/

fun main(): Unit = runBlocking {
    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
        println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
        delay(500)
        println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
    }

    launch { // context of the parent, main runBlocking coroutine
        println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
        delay(1000)
        println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
    }
}