package chapter06

fun foo(l: Long) = println(l)

fun main() {
    val b: Byte = 1
    val l = b + 1L
    foo(42)

    val a: Int = 1
    val c: Long = 2
    val d = a + c
}