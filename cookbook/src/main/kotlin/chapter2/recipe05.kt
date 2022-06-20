package chapter2

import kotlin.math.pow

fun main() {
    val b = 10.toString(2)
    println(b)

    val p = 10 `**` 2
    println(p)
}

infix fun Int.`**`(x: Int) = toDouble().pow(x).toInt()