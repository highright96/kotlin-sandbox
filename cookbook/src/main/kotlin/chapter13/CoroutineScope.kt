package chapter13

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    for( i in 0 until 10) {
        launch {
            delay(1000L - i * 10)
            print("하트$i ")
        }
    }
}