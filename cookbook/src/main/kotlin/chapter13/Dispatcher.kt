package chapter13

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launchWithIo("abc1")
    launchWithDefault("abc2")
}

suspend fun launchWithIo(url: String) = coroutineScope {
    withContext(Dispatchers.IO) {
        println(Thread.currentThread().name)
        delay(100)
        "withContextResults"
    }
}

suspend fun launchWithDefault(url: String) = coroutineScope {
    withContext(Dispatchers.Default) {
        println(Thread.currentThread().name)
        delay(100)
        "withContextResults"
    }
}