package chapter06

import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {

    /*
    (100 until 200)
        .map {
            println("map $it")
            it * 2
        }.first {
            println("filter $it")
            it % 3 == 0
        }

    println("-------------")
*/
    (100 until 2_000_000).asSequence()
        .map {
            println("map $it")
            it * 2
        }
        .filter {
            println("filter $it")
            it % 3 == 0
        }
        .first()

    println(nextPrime(1))
    println(firstNPrimes(10))
    println(primeLessThan1(10))
}

fun firstNPrimes(count: Int) =
    generateSequence(2, ::nextPrime)
        .take(count)
        .toList()

fun primeLessThan1(max: Int) =
    generateSequence(2) { n -> if (n < max) nextPrime(n) else null }
        .toList()
        .dropLast(1)

fun primeLessThan2(max: Int) =
    generateSequence(2, ::nextPrime)
        .takeWhile { it < max }
        .toList()

fun nextPrime(n: Int) =
    generateSequence(n + 1) { it + 1 }
        .first { it.isPrime() }

fun Int.isPrime() =
    this == 2 || (2..ceil(sqrt(this.toDouble())).toInt())
        .none { divisor -> this % divisor == 0 }