package chapter09

import chapter08.Person

interface GenericList<T> {
    operator fun get(index: Int): T
}

fun <T> ensureTrailingPeriod(seq: T)
    where T : CharSequence, T : Appendable {

}

fun printSum(c: Collection<*>) {
    val inList = c as? List<Int> ?: throw IllegalArgumentException()
    println(inList.sum())
}

fun main() {
    printSum(listOf(1, 2, 4))
    printSum(listOf(Person("a", 10)))
}