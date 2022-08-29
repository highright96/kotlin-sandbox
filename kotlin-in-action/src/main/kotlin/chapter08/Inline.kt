package chapter08

import java.util.concurrent.locks.Lock

inline fun <T> foo(action: () -> T) {
    try {
        action()
    } finally {
        // something...
    }
}

class LockOwner(val lock: Lock) {
    fun runUnderLock(body: () -> Unit) {
        synchronized(lock, body)
    }
}

fun main() {
    println("Before")
    foo() {
        println("Action")
    }
    println("After")
}