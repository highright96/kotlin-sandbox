package chapter13

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    println("Before")
    runBlocking {
        print("Hello, ")
        delay(200L)
        println("World!")
    }
    println("After")
}