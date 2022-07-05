package inflearn.lec03

import inflearn.lec01.Person

fun main() {

    val person = Person("남상우")
    println("이름 : ${person.name}")

    val name = "남상우"
    println("이름 : $name")

    val str = """
        abc
        efg
        ${name}
    """.trimIndent()
    println(str)

    val s = "ABC"
    println(s[0])
    println(s[1])
}