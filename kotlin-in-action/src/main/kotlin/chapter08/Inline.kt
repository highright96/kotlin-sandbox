package chapter08

import java.util.concurrent.locks.Lock

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    }
    finally {
        lock.unlock()
    }
}

fun main() {
    val l = Lock()
    synchronized(l) {

    }
}