package com.highright.coroutines.asynchronous_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val nums1 = (1..3).asFlow()
    val strs1 = flowOf("one", "two", "three")
    nums1.zip(strs1) { a, b -> "$a -> $b" }
        .collect { println(it) }

    val nums2 = (1..3).asFlow().onEach { delay(300) }
    val strs2 = flowOf("one", "two", "three").onEach { delay(400) }

    val startTime = System.currentTimeMillis()
    nums2.combine(strs2) { a, b -> "$a -> $b" } // compose a single string with "zip"
        .collect { value -> // collect and print
            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
}
