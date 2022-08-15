package chapter06

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun main() {
    val input: String? = null
    val notNull = input ?: fail("null")
}