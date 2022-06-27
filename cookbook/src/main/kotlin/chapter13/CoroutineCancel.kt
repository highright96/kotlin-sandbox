package chapter13

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/*
fun main() = runBlocking {
    val job = launch {
        repeat(100) {
            println("job : $it")
            delay(100)
        }
    }

    delay(500)
    println("Timeout")
    job.cancel()
    job.join()
    println("Done")
}
*/

fun main() = runBlocking {
    withTimeout(1000L) {
       repeat(50)  {
           println("job : $it")
           delay(100)
       }
    }
}