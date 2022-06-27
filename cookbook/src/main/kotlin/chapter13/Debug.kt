package chapter13

import kotlinx.coroutines.*

suspend fun extrievel1(url: String) = coroutineScope {
    withContext(Dispatchers.IO + CoroutineName("A")) {
        println("Extrievel1 data on ${Thread.currentThread().name}")
        delay(100)
        "withContextResults"
    }
}

suspend fun extrievel2(url: String) = coroutineScope {
    withContext(Dispatchers.Default + CoroutineName("B")) {
        println("Extrievel2 data on ${Thread.currentThread().name}")
        delay(100)
        "withContextResults"
    }
}

fun main() = runBlocking {
    val result1 = extrievel1("www.mysite.com")
    val result2 = extrievel2("www.mysite.com")

    println("result ${Thread.currentThread().name} $result1")
    println("result ${Thread.currentThread().name} $result2")
}