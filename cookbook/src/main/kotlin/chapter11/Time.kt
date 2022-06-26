package chapter11

import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        doubleIt(10)
    }
    println(time)
}

fun doubleIt(x: Int): Int {
    Thread.sleep(1000)
    return x * 2
}