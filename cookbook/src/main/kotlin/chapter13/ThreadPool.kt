package chapter13

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

/*
fun main() = runBlocking<Unit> {
    val dispatcher = Executors.newFixedThreadPool(10)
        .asCoroutineDispatcher()

    withContext(dispatcher) {
        delay(100)
        println(Thread.currentThread().name)
    }

    dispatcher.close()
}

fun main() = runBlocking<Unit> {
    val pool = Executors.newFixedThreadPool(10)

    withContext(pool.asCoroutineDispatcher()) {
        delay(100)
        println(Thread.currentThread().name)
    }

    pool.shutdown()
}
*/

fun main() = runBlocking<Unit> {
    Executors.newFixedThreadPool(10).asCoroutineDispatcher().use {
        delay(100)
        println(Thread.currentThread().name)
    }
}