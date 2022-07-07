package com.highright.coroutines.asynchronous_flow

import com.highright.coroutines.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/*
flow {...} 안에 존재하는 코드는 기본적으로 flow 에 상응하는 collector 로 부터 제공된 컨텍스트에서 실행된다.
메인 스레드에서 simple().collect 을 호출 했고, 결과적으로 simple 의 내부의 flow 도 메인스레드에서 호출된다
아래의 코드는 스레드의 차단이나 컨텍스트의 실행 등을 신경쓰지 않은, 비동기 코드 혹은 빠르게 실행되는 코드의 기본 예제라고 볼 수 있다.
언제든 메인 스레드가 차단되거나, 오래 걸리는 작업일 경우 문제가 생길수 있는 코드이다 정도로 이해하면 될 것 같다.
*/
fun simpleDefaultContext(): Flow<Int> = flow {
    log("Started simple flow")
    for (i in 1..3) {
        delay(100)
        log("Emitting $i")
        emit(i)
    }
}

/*
withContext 를 사용한 잘못된 아이템 배출
1. 긴 시간이 걸리는 혹은 CPU 를 소비하는 코드는 메인 스레드를 차단할 수 있기 때문에, Dispatcher.Default 에서 실행되어야 한다.
2. 보통 withContext 에 parameter 로 Context 를 넘겨줘서 사용하게 된다.
3. 그러나 flow {...} 빌더 안에 존재하는 코드는 호출하는 쪽의 context 를 존중하여 보존하기 때문에, 다른 Context 로 변경해서 아이템을 방출하는 것을 허락하지 않는다.

따라서 아래 코드는 에러가 발생한다.
*/
fun wrongEmissionWithContext(): Flow<Int> = flow {
    withContext(Dispatchers.Default) {
        for (i in 1..3) {
            delay(100L)
            emit(i)
        }
    }
}

/*
withContext 를 사용한 올바른 아이템 배출
1. 아래 결과에 주목하면, flow {...} 은 background 에서 실행되는 것을 볼 수 있고, 수집(collection) 될 때는 메인스레드에서 실행되는 것을 볼수 있다.
2. flow 의 순차 처리는 emit 1 -> collect 1 -> emit 2 -> collect 2 ... 로 진행된다.
*/
fun emissionWithContext(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        log("Emitting $i")
        emit(i) // emit next value
    }
}.flowOn(Dispatchers.Default)

fun main() = runBlocking {
    //simpleDefaultContext().collect { value -> log("Collected $value") }
    //wrongEmissionWithContext().collect { println(it) }
    emissionWithContext().collect { println(it) }
}