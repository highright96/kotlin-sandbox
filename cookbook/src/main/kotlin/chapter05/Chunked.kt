package chapter05

fun main() {
    val range = 0..10
    val chunked1 = range.chunked(3)
    println(chunked1) //[[0, 1, 2], [3, 4, 5], [6, 7, 8], [9, 10]]

    val chunked2 = range.chunked(3) { it.sum() } //[3, 12, 21, 19]
    println(chunked2)
}