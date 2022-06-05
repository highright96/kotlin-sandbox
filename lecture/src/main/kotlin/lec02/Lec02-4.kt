package lec02

import lec01.Person

fun main() {
    val person = Person("공부하는 개발자");
    println(startsWithAJava(person.name));
}

fun startsWithAJava(str: String): Boolean {
    return str.startsWith("A");
}