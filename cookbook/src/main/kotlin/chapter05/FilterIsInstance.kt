package chapter05

import java.time.LocalDate

fun main() {
    val list = listOf("a", LocalDate.now(), 3, 1, 4, "b")
    println(list)

    val strings = list.filter { it is String }
    //println(strings[0].length) 컴파일 X

    val rStrings = list.filterIsInstance<String>()
    println(rStrings[0].length)

    val rToStrings = list.filterIsInstanceTo(mutableListOf<String>())
    println(rToStrings[0].length)
}