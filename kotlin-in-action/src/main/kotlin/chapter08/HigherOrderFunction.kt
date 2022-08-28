package chapter08

import java.lang.StringBuilder

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println(result)
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null
)  {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        val str = transform?.invoke(element)
            ?: element.toString()
        result.append(str)
    }
}

fun main() {
    twoAndThree { a, b -> a + b}
}