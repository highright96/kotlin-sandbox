package chapter13

import kotlinx.coroutines.*

suspend fun retrievel(url: String) = coroutineScope {
    async {
        println("Retrieving data on ${Thread.currentThread().name}")
        delay(100)
        "asyncResults"
    }.await()
}

suspend fun extrievel(url: String) = coroutineScope {
    withContext(Dispatchers.Default) {
        println("Extrievel data on ${Thread.currentThread().name}")
        delay(100)
        "withContextResults"
    }
}

fun main() = runBlocking {
    val result1 = retrievel("www.mysite.com")
    println("result ${Thread.currentThread().name} $result1")

    val result2 = extrievel("www.mysite.com")
    println("result ${Thread.currentThread().name} $result2")
}